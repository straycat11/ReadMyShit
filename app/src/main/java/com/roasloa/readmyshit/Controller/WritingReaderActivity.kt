package com.roasloa.readmyshit.Controller

import android.app.Activity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Window
import com.roasloa.readmyshit.Model.Writing
import com.roasloa.readmyshit.R
import com.roasloa.readmyshit.Utilities.EXTRA_WRITING_TITLE

import kotlinx.android.synthetic.main.activity_writing_reader.*

class WritingReaderActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_writing_reader)



        val writing = intent.getParcelableExtra<Writing>(EXTRA_WRITING_TITLE)
        val resourceId = this.resources.getIdentifier(writing.image,"drawable",this.packageName)
        writingReaderBg.setImageResource(resourceId)
        writingReaderBg.alpha = 0.35f




        writingReaderTitle.text = writing.title
        writingReaderContent.text = writing.content
        writingReaderContent.movementMethod = ScrollingMovementMethod()
    }
}
