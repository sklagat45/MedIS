package com.sklagat46.medis.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.sklagat46.medis.R
import com.sklagat46.medis.ui.login.LoginActivity
import com.sklagat46.medis.views.Users
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tv_signin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        BtnSignUp.setOnClickListener {
            val username = ETUsername.text.toString().trim()
            val userEmail = ETUserEmail.text.toString().trim()
            val location = ETLocation.text.toString().trim()
            val number = ETphone_number.text.toString().trim()
            val password = ETPassword.text.toString().trim()




            if (username.isEmpty() || userEmail.isEmpty() || location.isEmpty() || number.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Enter your All Data!!", Toast.LENGTH_LONG).show()
            }
            if (password.length < 6) {
                Toast.makeText(
                    this,
                    "Password too short, enter minimum 6 characters",
                    Toast.LENGTH_LONG
                ).show()
            }
            val mRef = FirebaseDatabase.getInstance().reference.child("MedIS").child("users")
            val userId = mRef.push().key
            val user = Users(userId, username, userEmail, location, number)


            if (userId != null) {

                mRef.child(userId).setValue(user).addOnCompleteListener {

                    auth.createUserWithEmailAndPassword(userEmail, password)
                        .addOnCompleteListener(this) { task ->
                            if (!task.isSuccessful) {
                                Toast.makeText(this, "User Not created", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(
                                    this,
                                    "registered successful" + task.isSuccessful,
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(Intent(this, LoginActivity::class.java))
                                finish()
                            }
                        }
//                    Toast.makeText(this, "user data saved successfully", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}