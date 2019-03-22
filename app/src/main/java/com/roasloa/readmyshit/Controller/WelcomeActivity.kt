package com.roasloa.readmyshit.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.roasloa.readmyshit.R
import com.roasloa.readmyshit.Utilities.EXTRA_POEM_TITLE

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun welcomePoemClk(view: View){
        val poemSelectionIntent = Intent(this, MainActivity::class.java)
        startActivity(poemSelectionIntent)
    }
}
