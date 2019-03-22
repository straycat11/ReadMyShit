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
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.roasloa.readmyshit.Adapters.PoemCoverAdapter
import com.roasloa.readmyshit.Model.Poem
import com.roasloa.readmyshit.R
import com.roasloa.readmyshit.R.layout.*
import com.roasloa.readmyshit.Services.PoemDataService
import com.roasloa.readmyshit.Utilities.EXTRA_POEM_TITLE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.popup_window.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: PoemCoverAdapter
    lateinit var siir: Poem
    lateinit var popupWindow: PopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        adapter = PoemCoverAdapter(this, PoemDataService.poemList){poem ->

            val poemSelectionIntent = Intent(this, PoemReaderActivity::class.java)
            poemSelectionIntent.putExtra(EXTRA_POEM_TITLE, poem)
            siir = poem
//            startActivity(poemSelectionIntent)



            val inflater: LayoutInflater = LayoutInflater.from(this)


            val popupView = inflater.inflate(popup_window, null)

            val popupImage = popupView.findViewById<ImageView>(R.id.popupImage)
            val popupText = popupView.findViewById<TextView>(R.id.popupText)

            popupImage.setImageResource(this.resources.getIdentifier(poem.image, "drawable",this.packageName))
            popupText.text = poem.title

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
        val poemSelectionIntent = Intent(this, PoemReaderActivity::class.java)
        poemSelectionIntent.putExtra(EXTRA_POEM_TITLE, siir)
        startActivity(poemSelectionIntent)
        popupWindow.dismiss()


    }

}
