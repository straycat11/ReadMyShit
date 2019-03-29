package com.roasloa.readmyshit.Utilities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.TextView

class TypeWriter: TextView {

    constructor(context:Context) : super(context)
    constructor(context:Context, attrs:AttributeSet) : super(context, attrs)

    lateinit var mText: CharSequence
    var mIndex = 0
    var mDelay = 0L

    @SuppressLint("HandlerLeak")
    val mHandler = object : Handler(){

    }

    val characterAdder = Runnable { text = mText.subSequence(0, mIndex++) }

    fun animateText(txt: CharSequence){
        mText = txt
        mIndex = 0

        text = ""
        mHandler.removeCallbacks(characterAdder)
        mHandler.postDelayed(characterAdder, mDelay)

    }

    fun setCharacterDelay(m: Long){
        mDelay = m
    }





}