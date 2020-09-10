package com.sklagat46.medis.ui.household

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sklagat46.medis.R
import com.sklagat46.medis.adapters.HouseHoldAdapter
import com.sklagat46.medis.model.DataHolder
import com.sklagat46.medis.ui.AddHouseHold
import com.sklagat46.medis.ui.IndividualHouseData
import com.sklagat46.medis.views.HouseHoldViewHolder
import kotlinx.android.synthetic.main.activity_house_hold.*
import kotlinx.android.synthetic.main.house_hold_bar.*


class HouseHoldActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager

    var mAdapter: FirebaseRecyclerAdapter<DataHolder, HouseHoldViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_hold)

        add_data!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HouseHoldActivity, AddHouseHold::class.java))
        })

        sample_row!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@HouseHoldActivity, IndividualHouseData::class.java))
        })

        linearLayoutManager = LinearLayoutManager(this)
        data_recycler_view.layoutManager = linearLayoutManager

        val query: DatabaseReference =
            FirebaseDatabase.getInstance().reference.child("MedIS").child(
                "household data"
            ).child("")
                .child("");
        val options: FirebaseRecyclerOptions<DataHolder> = FirebaseRecyclerOptions.Builder<DataHolder>()
            .setQuery(query, DataHolder::class.java)
            .build()

        mAdapter = HouseHoldAdapter(options);
        data_recycler_view.adapter = mAdapter

    }
    @Override
    override fun onStart() {
        super.onStart();
        mAdapter?.startListening();    }

    @Override
    override fun onStop() {
        super.onStop();
        mAdapter?.stopListening();

    }

}