package com.roasloa.readmyshit.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import com.roasloa.readmyshit.Adapters.WritingCoverAdapter
import com.roasloa.readmyshit.Model.Writing
import com.roasloa.readmyshit.R
import com.roasloa.readmyshit.R.layout.*
import com.roasloa.readmyshit.Services.WritingDataService
import com.roasloa.readmyshit.Utilities.EXTRA_WRITING_TITLE
import kotlinx.android.synthetic.main.activity_main.*


class WritingMainActivity : AppCompatActivity() {

    lateinit var adapter: WritingCoverAdapter
    lateinit var yazi: Writing
    lateinit var popupWindow: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        adapter = WritingCoverAdapter(this, WritingDataService.writingList){writing ->

            val writingSelectionIntent = Intent(this, WritingReaderActivity::class.java)
            writingSelectionIntent.putExtra(EXTRA_WRITING_TITLE, writing)
            yazi = writing
//            startActivity(writingSelectionIntent)



            val inflater: LayoutInflater = LayoutInflater.from(this)


            val popupView = inflater.inflate(popup_window, null)

            val popupImage = popupView.findViewById<ImageView>(R.id.popupImage)
            val popupText = popupView.findViewById<TextView>(R.id.popupText)

            popupImage.setImageResource(this.resources.getIdentifier(writing.image, "drawable",this.packageName))
            popupText.text = writing.title

            val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,300F,resources.displayMetrics).toInt()
            val height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,600F,resources.displayMetrics).toInt()

            Log.d("PIX", "width is $width and the height is $height")
            var focusable = true

            popupWindow = PopupWindow(popupView, width, height, focusable)

            popupWindow.animationStyle = R.style.Animation_AppCompat_DropDownUp

            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)




        }



        val layoutManager = GridLayoutManager(this, 2)

        poemRecyclerView.layoutManager = layoutManager
        poemRecyclerView.adapter = adapter



    }

    fun startReadingBtnClicked(view: View){
        val writingSelectionIntent = Intent(this, WritingReaderActivity::class.java)
        writingSelectionIntent.putExtra(EXTRA_WRITING_TITLE, yazi)
        startActivity(writingSelectionIntent)
        popupWindow.dismiss()


    }

}
