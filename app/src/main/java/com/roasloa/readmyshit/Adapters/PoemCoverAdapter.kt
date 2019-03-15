package com.roasloa.readmyshit.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.roasloa.readmyshit.Model.Poem
import com.roasloa.readmyshit.R

class PoemCoverAdapter(val context: Context, val poems: List<Poem>, val itemClick: (Poem)-> Unit)
    : RecyclerView.Adapter<PoemCoverAdapter.PoemCoverHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PoemCoverHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.poem_cover, p0, false)

        return PoemCoverHolder(view, itemClick)
    }


    override fun getItemCount(): Int {
        return poems.count()
    }

    override fun onBindViewHolder(p0: PoemCoverHolder, p1: Int) {
        p0?.bindPoem(poems[p1], context)
    }

    inner class PoemCoverHolder(itemView: View?, val itemClick: (Poem) -> Unit) : RecyclerView.ViewHolder(itemView!!){
        val poemCoverImage = itemView?.findViewById<ImageView>(R.id.poemCoverImage)
        val poemTitleText = itemView?.findViewById<TextView>(R.id.poemTitle)


            fun bindPoem(poem: Poem, context: Context) {
                poemTitleText?.text = poem.title
                val resourceId = context.resources.getIdentifier(poem.image, "drawable",context.packageName)
                poemCoverImage?.setImageResource(resourceId)
                itemView.setOnClickListener{itemClick(poem)
                }
        }
    }
}