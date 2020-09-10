package com.sklagat46.medis.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sklagat46.medis.R
import com.sklagat46.medis.ui.household.HouseHoldActivity
import kotlinx.android.synthetic.main.activity_add_house_hold.*

class AddHouseHold : AppCompatActivity() {
    private var returnImg: ImageView? = null
    private var villageName: EditText? = null
    private var householdNumber: EditText? = null
    private var dateofData: EditText? = null
    private var IndividualCode: EditText? = null
    private var houseHeadName: EditText? = null
    private var houseHeadAge: EditText? = null
    private var individualName: EditText? = null
    private var description: EditText? = null
    private var btnSubmit: Button? = null
    private var selectedChronicIllness: String? = null

    private var status: String? = null
    private var relationship: String? = null



    lateinit var rgGender: RadioGroup
    lateinit var rbMale: RadioButton
    lateinit var rbFemale: RadioButton
    private var selectedGender: String? = null
    private var orphanChoice: String? = null
    private var birthCertChoice: String? = null
    private var schoolingChoice: String? = null
    private var chronicIllness: Spinner? = null
    private var coughingChoice: String? = null
    private var hIVstatus: String? = null
    private var waterAccess: String? = null
    private var treatedWater: String? = null
    private var fuctionalLatrines: String? = null
    private var handwashingFacility: String? = null
    private var disposalFacility: String? = null

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


    private var disability: String? = null
    private var otherDisability: EditText? = null

    private var tvHouseIndicators: TextView? = null

    private var remarks: EditText? = null

    private var mAuth: FirebaseAuth? = null
    private var mCurrentUser: DatabaseReference? = null

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_house_hold)

        returnImg = findViewById(R.id.return_to_houses)
        dateofData = findViewById(R.id.et_date)
        villageName = findViewById(R.id.et_village_name)
        houseHeadAge = findViewById(R.id.et_age)
        householdNumber = findViewById(R.id.et_household_num)
        houseHeadName = findViewById(R.id.et_hhh_name)
        IndividualCode = findViewById(R.id.et_individual_code)
        individualName = findViewById(R.id.et_individual_name)
        otherDisability = findViewById(R.id.et_other_disability)
        remarks = findViewById(R.id.et_remarks)
        chronicIllness = findViewById(R.id.sp_chronic_illnes)
        rgGender = findViewById(R.id.rg_gender)
        rbMale = findViewById(R.id.male_btn)
        rbFemale = findViewById(R.id.female_btn)


        btnSubmit = findViewById(R.id.btn_submit)
        btnMoh513 = findViewById(R.id.btn_moh513)

        mAuth = FirebaseAuth.getInstance()
        if (mAuth!!.currentUser != null) {
            mCurrentUser = FirebaseDatabase.getInstance()
                .reference.child("MedIS").child("users")
                .child(
                    mAuth!!.currentUser!!
                        .uid
                )
        }
        returnImg!!.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@AddHouseHold, HouseHoldActivity::class.java))
            finish()
        })


        btnMoh513!!.setOnClickListener(View.OnClickListener {

            counter++
            if (counter % 2 == 0) {
                moh513_ll.visibility == View.VISIBLE//show
            } else {
                moh513_ll.visibility == View.GONE//hide
            }
        })



        btnSubmit!!.setOnClickListener(View.OnClickListener {
            selectedGender
            if (rgGender.checkedRadioButtonId != -1) {
                if (rbMale.isChecked) {
                    selectedGender = "male"
                } else if (rbFemale.isChecked) {
                    selectedGender = "female"
                }
            }

            if (rg_relationship.checkedRadioButtonId != -1) {
                if (rb_hhh.isChecked) {
                    relationship = "HHH"
                } else if (rb_partner.isChecked) {
                    relationship = "Partner"
                } else if (rb_son.isChecked) {
                    relationship = "Son"
                }else if (rb_daughter.isChecked) {
                    relationship = "Daughter"
                }else if (rb_gardian.isChecked) {
                    relationship = "Gardian"
                }
            }

            if (rg_status.checkedRadioButtonId != -1) {
                if (rb_refer.isChecked) {
                    status = "Referral"
                } else if (rb_closed.isChecked) {
                    status = "Closed"
                }else if (rb_follow_up.isChecked) {
                    status = "Follow up"
                }
            }
            if (rg_orphanage.checkedRadioButtonId != -1) {
                if (rb_orphan_yes.isChecked) {
                    orphanChoice = "yes"
                } else if (rb_cough_no.isChecked) {
                    orphanChoice = "No"
                }
            }
            if (rg_birthcert.checkedRadioButtonId != -1) {
                if (Has_birthcert_yes.isChecked) {
                    birthCertChoice = "yes"
                } else if (Has_birthcert_no.isChecked) {
                    birthCertChoice = "No"
                }
            }
            if (rg_schooling.checkedRadioButtonId != -1) {
                if (rb_schooling_yes.isChecked) {
                    schoolingChoice = "yes"
                } else if (rb_schooling_no.isChecked) {
                    schoolingChoice = "No"
                }
            }
            if (rg_cough.checkedRadioButtonId != -1) {
                if (rb_cough_yes.isChecked) {
                    coughingChoice = "yes"
                } else if (rb_cough_no.isChecked) {
                    coughingChoice = "No"
                }
            }
            if (rg_hiv_status.checkedRadioButtonId != -1) {
                if (rb_hiv_yes.isChecked) {
                    hIVstatus = "positive"
                } else if (rb_hiv_no.isChecked) {
                    hIVstatus = "Negative"
                }
            }
            if (rg_water_access.checkedRadioButtonId != -1) {
                if (rb_water_yes.isChecked) {
                    waterAccess = "yes"
                } else if (rb_water_no.isChecked) {
                    waterAccess = "No"
                }
            }
            if (rg_treated_water.checkedRadioButtonId != -1) {
                if (rb_water_treated_yes.isChecked) {
                    treatedWater = "yes"
                } else if (rb_water_treated_no.isChecked) {
                    treatedWater = "No"
                }
            }
            if (rg_laterines.checkedRadioButtonId != -1) {
                if (rb_latrines_yes.isChecked) {
                    fuctionalLatrines = "yes"
                } else if (rb_latrines_no.isChecked) {
                    fuctionalLatrines = "No"
                }
            }
            if (rg_handwashing.checkedRadioButtonId != -1) {
                if (rb_handwashing_yes.isChecked) {
                    handwashingFacility = "yes"
                } else if (rb_handwashing_no.isChecked) {
                    handwashingFacility = "No"
                }
            }
            if (rg_litter_disposal.checkedRadioButtonId != -1) {
                if (rb_refuse_disposal_yes.isChecked) {
                    disposalFacility = "yes"
                } else if (rb_refuse_disposal_no.isChecked) {
                    disposalFacility = "No"
                }
            }

            selectedChronicIllness = sp_chronic_illnes.selectedItem.toString()
            disability = sp_disability.selectedItem.toString()
            val village_name = villageName!!.text.toString().trim()
            val household_number = householdNumber!!.text.toString().trim()
            val dataDate = dateofData!!.text.toString().trim()
            val Individual_code = IndividualCode!!.text.toString().trim()
            val house_headName = houseHeadName!!.text.toString().trim()
            val house_headAge = houseHeadAge!!.text.toString().trim()
            val selected_gender = selectedGender!!.toString().trim()
            val orphan_choice = orphanChoice.toString().trim()
            val individual_name = individualName!!.text.toString().trim()
            val birth_certChoice = birthCertChoice!!.toString().trim()
            val schooling_choice = schoolingChoice!!.toString().trim()
            val coughing_choice = coughingChoice!!.toString().trim()
            val other_disability = otherDisability!!.text.toString().trim()
            val hIV_status = hIVstatus!!.toString().trim()
            val water_access = waterAccess!!.toString().trim()
            val treated_water = treatedWater!!.toString().trim()
            val fuctional_latrines = fuctionalLatrines!!.toString().trim()
            val handwashing_facility = handwashingFacility!!.toString().trim()
            val disposal_facility = disposalFacility!!.toString().trim()
            val currentUser = mCurrentUser!!.toString().trim()
            val status_select = status!!.toString().trim()
            val mRelationship = relationship!!.toString().trim()



            if (household_number.isEmpty() || Individual_code.isEmpty()){
                Toast.makeText(this, "please You are missing house_number or individual code!!", Toast.LENGTH_LONG).show()
            }else {
//            pushPatientData()

                val mRef = FirebaseDatabase.getInstance().reference
                    .child("MedIS").child("household data").child(household_number)
                    .child(Individual_code)
//        val householdId=mRef.push().key

                //Writing Hashmap
                val mhouseMap: MutableMap<String, Any> = HashMap()

                mhouseMap["villageName"] = village_name
                mhouseMap["householdNumber"] = household_number
                mhouseMap["dateofData"] = dataDate
                mhouseMap["IndividualCode"] = Individual_code
                mhouseMap["houseHeadName"] = house_headName
                mhouseMap["houseHeadAge"] = house_headAge
                mhouseMap["selectedGender"] = selected_gender
                mhouseMap["orphanChoice"] = orphan_choice
                mhouseMap["individualName"] = individual_name
                mhouseMap["birthCertChoice"] = birth_certChoice
                mhouseMap["schoolingChoice"] = schooling_choice
                mhouseMap["coughing_choice"] = coughing_choice
                mhouseMap["otherDisability"] = other_disability
                mhouseMap["hIVstatus"] = hIV_status
                mhouseMap["waterAccess"] = water_access
                mhouseMap["treatedWater"] = treated_water
                mhouseMap["fuctionalLatrines"] = fuctional_latrines
                mhouseMap["handwashingFacility"] = handwashing_facility
                mhouseMap["disposalFacility"] = disposal_facility
                mhouseMap["chv ID"] = currentUser
                mhouseMap["status"] = status_select
                mhouseMap["relationship"] = mRelationship


                mRef.updateChildren(mhouseMap).addOnCompleteListener {
                    Toast.makeText(
                        applicationContext,
                        "user data saved successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                }


                val mHouseRef = FirebaseDatabase.getInstance().reference
                .child("MedIS").child("moh513").child(household_number).child(Individual_code)

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

            fpMethods = sp_fp_methods.selectedItem.toString()
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
            val mbalancedDiet = balancedDiet!!.toString().trim()
            val mseverelyMalnourished = severelyMalnourished!!.toString().trim()
            val mmoderateMalnoushed = moderateMalnoushed!!.toString().trim()
            val mllinUse = llinUse!!.toString().trim()
            val fp_methods = fpMethods!!.toString().trim()



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


                mHouseRef.updateChildren(moh513Map).addOnCompleteListener {
                    Toast.makeText(
                        applicationContext,
                        "user data saved successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        })

    }

}