package com.sklagat46.medis.ui

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reset_password.*
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.sklagat46.medis.R


class ResetPassword : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        mAuth = FirebaseAuth.getInstance()

        btnResetPassword.setOnClickListener {
            val email = edtResetEmail.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Enter your email!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth!!.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@ResetPassword, "Check email to reset your password!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@ResetPassword, "Fail to send reset password email!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}


