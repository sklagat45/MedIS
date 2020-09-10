package com.sklagat46.medis.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import com.sklagat46.medis.R
import kotlinx.android.synthetic.main.activity_events.*

class EventsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        event_link_one!!.movementMethod = LinkMovementMethod.getInstance()
    }
}