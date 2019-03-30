package com.roasloa.readmyshit.Utilities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.TextView
import java.util.*
import kotlin.random.Random

class TypeWriter: TextView {

    constructor(context:Context) : super(context)
    constructor(context:Context, attrs:AttributeSet) : super(context, attrs)

    lateinit var mText: CharSequence
    var mIndex = 0
    var mDelay = 0L



    @SuppressLint("HandlerLeak")
    val mHandler = object : Handler(){

    }

    private var characterAdder: Runnable = object: Runnable {
        override fun run() {
            text = mText.subSequence(0,mIndex++)

            if (mIndex <= mText.length) {
                handler.postDelayed(this, mDelay);
            }
        }

    }

    fun animateText(txt: CharSequence){
        mText = txt
        mIndex = 0

        text = ""
        mHandler.removeCallbacks(characterAdder)
        mHandler.postDelayed(characterAdder, Random.nextLong(mDelay-mDelay/4,mDelay+mDelay/4))

    }

    fun setCharacterDelay(m: Long){
        mDelay = m
    }

}