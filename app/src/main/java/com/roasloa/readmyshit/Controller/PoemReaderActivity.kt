package com.roasloa.readmyshit.Controller

import android.app.Activity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Window
import com.roasloa.readmyshit.Model.Poem
import com.roasloa.readmyshit.R
import com.roasloa.readmyshit.Utilities.EXTRA_POEM_TITLE
import kotlinx.android.synthetic.main.activity_poem_reader.*

class PoemReaderActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_poem_reader)



        val poem = intent.getParcelableExtra<Poem>(EXTRA_POEM_TITLE)
        val resourceId = this.resources.getIdentifier(poem.image,"drawable",this.packageName)
        poemReaderBg.setImageResource(resourceId)
        poemReaderBg.alpha = 0.35f




        writingReaderTitle.text = poem.title
        poemReaderContent.text = poem.content
    }
}
