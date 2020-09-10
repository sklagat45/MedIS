package com.sklagat46.medis.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sklagat46.medis.R
import kotlinx.android.synthetic.main.activity_add_house_hold.*

class Moh513Activity : AppCompatActivity() {

    private var villageName: EditText? = null
    private var householdNumber: EditText? = null
    private var dateofData: EditText? = null
    private var IndividualCode: EditText? = null
    private var houseHeadName: EditText? = null
    private var individualName: EditText? = null
    private var mCurrentUser: DatabaseReference? = null


    private var pregnant: String? = null
    private var healthBook: String? = null
    private var anc4Times: String? = null
    private var birthAttendant: String? = null
    private var breastFeeding: String? = null
    private var fpMethods: String? = null
    private var penta1: String? = null
    private var penta2: String? = null
    private var measlesImmune: String? = null
    private var immunisedFully: String? = null
    private var vitaminA: String? = null
    private var balancedDiet: String? = null
    private var severelyMalnourished: String? = null
    private var moderateMalnoushed: String? = null
    private var llinUse: String? = null
    private var btnMoh513: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moh513)

        dateofData = findViewById(R.id.et_date)
        villageName = findViewById(R.id.et_village_name)
        householdNumber = findViewById(R.id.et_household_num)
        houseHeadName = findViewById(R.id.et_hhh_name)
        IndividualCode = findViewById(R.id.et_individual_code)
        individualName = findViewById(R.id.et_individual_name)


        val mAuth = FirebaseAuth.getInstance();
        if (mAuth!!.currentUser != null) {
           val  mCurrentUser = FirebaseDatabase.getInstance()
                .reference.child("MedIS").child("users")
                .child(
                    mAuth!!.currentUser!!
                        .uid
                )
        }


        //Writing Hashmap


        if (rg_pregnant.checkedRadioButtonId != -1) {
            if (rb_pregnant_yes.isChecked) {
                pregnant = "yes"
            } else if (rb_pregnant_no.isChecked) {
                pregnant = "No"
            }
        }
        if (rg_health_book.checkedRadioButtonId != -1) {
            if (rb_health_book_yes.isChecked) {
                healthBook = "yes"
            } else if (rb_health_book_no.isChecked) {
                healthBook = "No"
            }
        }
        if (rg_anc_4times.checkedRadioButtonId != -1) {
            if (rb_anc_4times_yes.isChecked) {
                anc4Times = "yes"
            } else if (rb_anc_4times_no.isChecked) {
                anc4Times = "No"
            }
        }
        if (rg_birth_attendant.checkedRadioButtonId != -1) {
            if (rb_birth_attendant_yes.isChecked) {
                birthAttendant = "yes"
            } else if (rb_birth_attendant_no.isChecked) {
                birthAttendant = "No"
            }
        }
        if (rg_breast_feeding.checkedRadioButtonId != -1) {
            if (rb_breast_feeding_yes.isChecked) {
                breastFeeding = "yes"
            } else if (rb_breast_feeding_no.isChecked) {
                breastFeeding = "No"
            }
        }
        if (rg_penta1.checkedRadioButtonId != -1) {
            if (rb__penta1_given_yes.isChecked) {
                penta1 = "yes"
            } else if (rb__penta1_given_no.isChecked) {
                penta1 = "No"
            }
        }
        if (rg_penta2.checkedRadioButtonId != -1) {
            if (rb__penta2_given_yes.isChecked) {
                penta2 = "yes"
            } else if (rb__penta2_given_no.isChecked) {
                penta2 = "No"
            }
        }
        if (rg_Measles.checkedRadioButtonId != -1) {
            if (rb_measles_given_yes.isChecked) {
                measlesImmune = "yes"
            } else if (rb_measles_given_no.isChecked) {
                measlesImmune = "No"
            }
        }
        if (rg_immunised.checkedRadioButtonId != -1) {
            if (rb_immunised_yes.isChecked) {
                immunisedFully = "yes"
            } else if (rb_immunised_no.isChecked) {
                immunisedFully = "No"
            }
        }
        if (gr_vitamin_a.checkedRadioButtonId != -1) {
            if (rb_vitamin_a_yes.isChecked) {
                vitaminA = "yes"
            } else if (rb_vitamin_a_no.isChecked) {
                vitaminA = "No"
            }
        }
        if (rg_balanced_diet.checkedRadioButtonId != -1) {
            if (rb_balanced_diet_yes.isChecked) {
                balancedDiet = "yes"
            } else if (rb_balanced_diet_no.isChecked) {
                balancedDiet = "No"
            }
        }
        if (rg_Severely_malnourished.checkedRadioButtonId != -1) {
            if (rb_Severely_malnourished_yes.isChecked) {
                severelyMalnourished = "yes"
            } else if (rb_severely_malnourished_no.isChecked) {
                severelyMalnourished = "No"
            }
        }
        if (rg_moderate_malnourished.checkedRadioButtonId != -1) {
            if (rb_moderate_malnourished_yes.isChecked) {
                moderateMalnoushed = "yes"
            } else if (rb_moderate_malnourished_no.isChecked) {
                moderateMalnoushed = "No"
            }
        }
        if (rg_llin_use.checkedRadioButtonId != -1) {
            if (rb_lllin_yes.isChecked) {
                llinUse = "yes"
            } else if (rb_lllin_no.isChecked) {
                llinUse = "No"
            }
        }



        val village_name = villageName!!.text.toString().trim()
        val household_number = householdNumber!!.text.toString().trim()
        val dataDate = dateofData!!.text.toString().trim()
        val Individual_code = IndividualCode!!.text.toString().trim()
        val house_headName = houseHeadName!!.text.toString().trim()
        fpMethods = sp_fp_methods.selectedItem.toString();
        val mpregnant = pregnant!!.toString().trim()
        val mhealthBook = healthBook!!.toString().trim()
        val mAnc4Times = anc4Times!!.toString().trim()
        val mBirthAttendant = birthAttendant!!.toString().trim()
        val mBreastFeeding = breastFeeding!!.toString().trim()
        val mpenta1 = penta1!!.toString().trim()
        val mpenta2 = penta2!!.toString().trim()
        val mMeaslesImmune = measlesImmune!!.toString().trim()
        val mImmunisedFully = immunisedFully!!.toString().trim()
        val mvitaminA = vitaminA!!.toString().trim()
        val individual_name = individualName!!.text.toString().trim()
        val mbalancedDiet = balancedDiet!!.toString().trim()
        val mseverelyMalnourished = severelyMalnourished!!.toString().trim()
        val mmoderateMalnoushed = moderateMalnoushed!!.toString().trim()
        val mllinUse = llinUse!!.toString().trim()
        val fp_methods = fpMethods!!.toString().trim()
        val currentUser = mCurrentUser!!.toString().trim()




        val moh513Map: MutableMap<String, Any> = HashMap()
        moh513Map["pregnant"] = mpregnant
        moh513Map["healthBook"] = mhealthBook
        moh513Map["anc4Times"] = mAnc4Times
        moh513Map["birthAttendant"] = mBirthAttendant
        moh513Map["breastFeeding"] = mBreastFeeding
        moh513Map["penta1"] = mpenta1
        moh513Map["penta2"] = mpenta2
        moh513Map["measlesImmune"] = mMeaslesImmune
        moh513Map["immunisedFully"] = mImmunisedFully
        moh513Map["vitaminA"] = mvitaminA
        moh513Map["balancedDiet"] = mbalancedDiet
        moh513Map["severelyMalnourished"] = mseverelyMalnourished
        moh513Map["moderateMalnoushed"] = mmoderateMalnoushed
        moh513Map["llinUse"] = mllinUse
        moh513Map["chv ID"] = currentUser
        moh513Map["householdNumber"] = household_number
        moh513Map["IndividualCode"] = Individual_code
        moh513Map["houseHeadName"] = house_headName
        moh513Map["individualName"] = individual_name


        val mHouseRef = FirebaseDatabase.getInstance().reference
            .child("MedIS").child("moh513").child(household_number).child(Individual_code);


        mHouseRef.updateChildren(moh513Map).addOnCompleteListener {
            Toast.makeText(
                applicationContext,
                "user data saved successfully",
                Toast.LENGTH_LONG
            ).show();
        };
    }

}