package com.sklagat46.medis.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.sklagat46.medis.R
import kotlinx.android.synthetic.main.activity_individual_house_data.*


class IndividualHouseData : AppCompatActivity() {

    private var mHouseholdNo: TextView? = null
    private var mHhhName: TextView? = null
    private var mMembersNo: TextView? = null
    private var mWateraccess: TextView? = null
    private var mFuctionalLatrines: TextView? = null
    private var mRefuseDisposal: TextView? = null
    private var mTreatedWater: TextView? = null
    private var mHandwashing: TextView? = null
    private var mRootRef: DatabaseReference? = null
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_house_data)
        mHouseholdNo = findViewById(R.id.house_hold_id);
        mHhhName = findViewById(R.id.hhh_name);
        mMembersNo = findViewById(R.id.members_no);
        mWateraccess = findViewById(R.id.tv_water_access);
        mFuctionalLatrines = findViewById(R.id.tv_functional_latrines);
        mRefuseDisposal = findViewById(R.id.tv_refuse_disposal);
        mTreatedWater = findViewById(R.id.tv_treated_water);
        mHandwashing = findViewById(R.id.tv_hand_washing)

        recyclerView = findViewById(R.id.individual_data_recycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        add_member!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@IndividualHouseData, AddIndividualActivity::class.java))
            finish()
        })


        mRootRef = FirebaseDatabase.getInstance().reference.child("MedIS")
            .child("household data").child("12536212")
            .child("002");


        mRootRef!!.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val householdNumber = dataSnapshot.child("householdNumber").getValue(String::class.java)
                val houseHeadName = dataSnapshot.child("houseHeadName").getValue(String::class.java)
                val waterAccess = dataSnapshot.child("waterAccess").getValue(String::class.java)
                val fuctionalLatrines = dataSnapshot.child("fuctionalLatrines").getValue(String::class.java)
                val treatedWater = dataSnapshot.child("treatedWater").getValue(String::class.java)
                val handwashingFacility = dataSnapshot.child("handwashingFacility").getValue(String::class.java)
                val disposalFacility = dataSnapshot.child("disposalFacility").getValue(String::class.java)
                val name = dataSnapshot.child("Name").getValue(String::class.java)



//                val map = dataSnapshot.value as Map<*, *>?

////                val householdNumber = dataSnapshot.value
//                val houseHeadName = dataSnapshot.value
                val value = dataSnapshot.value



                mHouseholdNo!!.text = householdNumber
                mHhhName!!.text = houseHeadName
//                mMembersNo!!.text = value as CharSequence?
                mWateraccess!!.text = waterAccess
                mFuctionalLatrines!!.text = fuctionalLatrines
                mTreatedWater!!.text = treatedWater
                mRefuseDisposal!!.text = handwashingFacility
                mHandwashing!!.text = disposalFacility
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@IndividualHouseData, "Error fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })


        
    }


}
