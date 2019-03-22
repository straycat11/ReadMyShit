package com.roasloa.readmyshit.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.roasloa.readmyshit.Model.Writing
import com.roasloa.readmyshit.R

class WritingCoverAdapter(val context: Context, val writings: List<Writing>, val itemClick: (Writing)-> Unit)
    : RecyclerView.Adapter<WritingCoverAdapter.WritingCoverHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): WritingCoverHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.writing_cover, p0, false)

        return WritingCoverHolder(view, itemClick)
    }


    override fun getItemCount(): Int {
        return writings.count()
    }

    override fun onBindViewHolder(p0: WritingCoverHolder, p1: Int) {
        p0?.bindWriting(writings[p1], context)
    }

    inner class WritingCoverHolder(itemView: View?, val itemClick: (Writing) -> Unit) : RecyclerView.ViewHolder(itemView!!){
        val writingCoverImage = itemView?.findViewById<ImageView>(R.id.writingCoverImage)
        val writingTitleText = itemView?.findViewById<TextView>(R.id.writingTitle)


            fun bindWriting(writing: Writing, context: Context) {
                writingTitleText?.text = writing.title
                val resourceId = context.resources.getIdentifier(writing.image, "drawable",context.packageName)
                writingCoverImage?.setImageResource(resourceId)
                itemView.setOnClickListener{itemClick(writing)
                }
        }
    }
}