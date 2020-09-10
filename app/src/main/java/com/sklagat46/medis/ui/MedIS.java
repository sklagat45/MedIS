package com.sklagat46.medis.ui;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedIS extends Application {

    private DatabaseReference mRef;

    @Override
    public void onCreate() {
        super.onCreate();

        //Offline support
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            mRef = FirebaseDatabase.getInstance()
                    .getReference().child("MedIS").child("users")
                    .child(mAuth.getCurrentUser()
                            .getUid());
        }
    }
}
