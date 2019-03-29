package com.roasloa.readmyshit.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.roasloa.readmyshit.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        typeWriter.setCharacterDelay(150L)
        typeWriter.animateText("Hello there!")
    }

    fun welcomePoemClk(view: View){
        val poemSelectionIntent = Intent(this, MainActivity::class.java)
        startActivity(poemSelectionIntent)
    }

    fun welcomeWritingClk(view: View) {
        val writingSelectionIntent = Intent(this, WritingMainActivity::class.java)
        startActivity(writingSelectionIntent)
    }
}
