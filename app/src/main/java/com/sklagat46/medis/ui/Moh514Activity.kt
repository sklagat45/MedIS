package com.sklagat46.medis.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.sklagat46.medis.R
import kotlinx.android.synthetic.main.activity_moh514.*

class Moh514Activity : AppCompatActivity() {

    private var mCouncelled: String? = null
    private var mSkilledAttendant: String? = null
    private var mDeliveryTimeReturn: String? = null
    private var mBreastFeedingCouncelled: String? = null
    private var mFPCommodities: String? = null
    private var mGrowthMonitoring: String? = null
    private var mSevereMalnutrition: String? = null
    private var mModerateMalnutrition: String? = null
    private var mDewormed: String? = null
    private var btnSubmit: Button? = null

    private var mHouseHoldNum: EditText? = null
    private var mIndividualCode: EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moh514)

        btnSubmit = findViewById(R.id.btn_msubmit)

        mHouseHoldNum = findViewById(R.id.et_household_number)
        mIndividualCode = findViewById(R.id.m_et_individual_code)

        btnSubmit!!.setOnClickListener(View.OnClickListener {
            if (rg_counselling.checkedRadioButtonId != -1) {
                if (rb_counsell_yes.isChecked) {
                    mCouncelled = "Yes"
                } else if (rb_counsell_no.isChecked) {
                    mCouncelled = "NO"
                }
            }
            if (rg_skilled_attendant.checkedRadioButtonId != -1) {
                if (rb_skilled_attendant_yes.isChecked) {
                    mSkilledAttendant = "Yes"
                } else if (rb_skilled_attendant_no.isChecked) {
                    mSkilledAttendant = "No"
                }
            }
            if (rg_delivery_time.checkedRadioButtonId != -1) {
                if (rb_delivery_time_yes.isChecked) {
                    mDeliveryTimeReturn = "Yes"
                } else if (rb_delivery_time_no.isChecked) {
                    mDeliveryTimeReturn = "No"
                }
            }
            if (rg_breastfeeding_counsell.checkedRadioButtonId != -1) {
                if (rb_breastfeeding_counsell_yes.isChecked) {
                    mBreastFeedingCouncelled = "Yes"
                } else if (rb_breastfeeding_counsell_no.isChecked) {
                    mBreastFeedingCouncelled = "No"
                }
            }
            if (rg_fp_commodities.checkedRadioButtonId != -1) {
                if (rb_fp_commodities_yes.isChecked) {
                    mFPCommodities = "Yes"
                } else if (rb_fp_commodities_no.isChecked) {
                    mFPCommodities = "No"
                }
            }

            if (rg_growth_monitoring.checkedRadioButtonId != -1) {
                if (rb_growth_monitoring_yes.isChecked) {
                    mGrowthMonitoring = "Yes"
                } else if (rb_growth_monitoring_no.isChecked) {
                    mGrowthMonitoring = "No"
                }
            }
            if (rg_child_severe_malnutrition.checkedRadioButtonId != -1) {
                if (rb_child_severe_malnutrition_yes.isChecked) {
                    mSevereMalnutrition = "Yes"
                } else if (rb_child_severe_malnutrition_no.isChecked) {
                    mSevereMalnutrition = "No"
                }
            }
            if (rg_child_moderate_malnutrition.checkedRadioButtonId != -1) {
                if (rb_child_severe_malnutrition_yes.isChecked) {
                    mModerateMalnutrition = "Yes"
                } else if (rb_child_severe_malnutrition_no.isChecked) {
                    mModerateMalnutrition = "No"
                }
            }
            if (rg_dewormed.checkedRadioButtonId != -1) {
                if (rb_dewormed_yes.isChecked) {
                    mDewormed = "Yes"
                } else if (rb_dewormed_no.isChecked) {
                    mDewormed = "No"
                }
            }

            val mhousehold_number = mHouseHoldNum!!.text.toString().trim()
            val mIndividual_code = mIndividualCode!!.text.toString().trim()
            val counselled = mCouncelled!!.toString().trim()
            val skilledAttendant = mSkilledAttendant!!.toString().trim()
            val quickReturnAfterDelivery = mDeliveryTimeReturn!!.toString().trim()
            val breastFeedingCounselled = mBreastFeedingCouncelled!!.toString().trim()
            val fpCommodities = mFPCommodities!!.toString().trim()
            val growthMonitoring = mGrowthMonitoring!!.toString().trim()
            val severeMulnutrition = mSevereMalnutrition!!.toString().trim()
            val moderateMulnutrition = mModerateMalnutrition.toString().trim()
            val dewormed = mDewormed!!.toString().trim()

            if (mhousehold_number.isEmpty() || mIndividual_code.isEmpty()){
                Toast.makeText(this, "Enter your email Address!!", Toast.LENGTH_LONG).show()
            }else {

                val mRef = FirebaseDatabase.getInstance().reference
                    .child("MedIS").child("moh514").child(mhousehold_number).child(mIndividual_code)


                val mMoh514: MutableMap<String, Any> = HashMap()

                mMoh514["householdNumber"] = mhousehold_number
                mMoh514["IndividualCode"] = mIndividual_code
                mMoh514["counselled"] = counselled
                mMoh514["skilledAttendant"] = skilledAttendant
                mMoh514["quickReturnAfterDelivery"] = quickReturnAfterDelivery
                mMoh514["breastFeedingCounselled"] = breastFeedingCounselled
                mMoh514["fpCommodities"] = fpCommodities
                mMoh514["growthMonitoring"] = growthMonitoring
                mMoh514["severeMulnutrition"] = severeMulnutrition
                mMoh514["moderateMulnutrition"] = moderateMulnutrition
                mMoh514["child_dewormed"] = dewormed

                mRef.updateChildren(mMoh514).addOnCompleteListener {
                    Toast.makeText(
                        applicationContext,
                        "user data saved successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

    }
}