package com.roasloa.readmyshit.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.roasloa.readmyshit.Adapters.PoemCoverAdapter
import com.roasloa.readmyshit.R
import com.roasloa.readmyshit.Services.PoemDataService
import com.roasloa.readmyshit.Utilities.EXTRA_POEM_TITLE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: PoemCoverAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = PoemCoverAdapter(this, PoemDataService.poemList){poem ->

            val poemSelectionIntent = Intent(this, PoemReaderActivity::class.java)
            poemSelectionIntent.putExtra(EXTRA_POEM_TITLE, poem)
            startActivity(poemSelectionIntent)

        }

        val layoutManager = GridLayoutManager(this, 2)

        poemRecyclerView.layoutManager = layoutManager
        poemRecyclerView.adapter = adapter
    }
}
