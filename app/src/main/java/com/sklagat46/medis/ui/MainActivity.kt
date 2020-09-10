package com.sklagat46.medis.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sklagat46.medis.R

import com.sklagat46.medis.ui.household.HouseHoldActivity
import com.sklagat46.medis.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_app_bar.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        house_hold.setOnClickListener {
            startActivity(Intent(this, HouseHoldActivity::class.java))
        }
        referral.setOnClickListener {
            startActivity(Intent(this, ReferralActivity::class.java))
        }
        reports.setOnClickListener {
            startActivity(Intent(this, ReportsActivity::class.java))
        }
        e_learning.setOnClickListener {
            startActivity(Intent(this, ReferralActivity::class.java))
        }
        events.setOnClickListener {
            startActivity(Intent(this, EventsActivity::class.java))
        }

        logout!!.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val signin_Intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(signin_Intent)
            finish()
        }
    }

}


