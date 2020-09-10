package com.sklagat46.medis.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sklagat46.medis.R
import com.sklagat46.medis.ui.MainActivity
import com.sklagat46.medis.ui.RegisterActivity
import com.sklagat46.medis.ui.ResetPassword
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        Btn_login_SignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        tv_reset.setOnClickListener {
            startActivity(Intent(this, ResetPassword::class.java))
        }

        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        BtnSignIn.setOnClickListener {
            val email = ETLoginUserEmail.text.toString().trim()
            val password = ET_login_password.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter your email.", Toast.LENGTH_SHORT).show()
            }
            if (password.isEmpty()) {
                Toast.makeText(applicationContext, "Please Enter your Password", Toast.LENGTH_SHORT).show()
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (!task.isSuccessful) {
                        if (password.length < 6) {
                            ET_login_password.error = "password mismatch!"
                        } else {
                            Toast.makeText(this, "Authentication Failed", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                }

        }

    }
}