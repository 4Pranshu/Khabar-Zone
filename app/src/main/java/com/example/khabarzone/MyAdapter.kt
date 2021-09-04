package com.example.khabarzone

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val context: Context, val khabarModelArrayList: ArrayList<KhabarModel>) :
    RecyclerView.Adapter<KhabarViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KhabarViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)
        return KhabarViewHolder(view)
    }

    override fun onBindViewHolder(holder: KhabarViewHolder, position: Int) {
        holder.cd_view.setOnClickListener {
            val cIntent = Intent(context, myWebView::class.java)

            cIntent.putExtra("url", khabarModelArrayList[position].url)
            context.startActivity(cIntent)
        }

        holder.mauthor.text = khabarModelArrayList[position].author
        holder.mcontent.text = khabarModelArrayList[position].description
        holder.mdate.text = khabarModelArrayList[position].publishedAt
        holder.mheading.text = khabarModelArrayList[position].title
        Glide.with(context).load(khabarModelArrayList[position].urlToImage).into(holder.mImageView)
    }

    override fun getItemCount(): Int {
        return khabarModelArrayList.size
    }
}

class KhabarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mheading = itemView.findViewById<TextView>(R.id.NewsHeading)
    val mcontent = itemView.findViewById<TextView>(R.id.content)
    val mImageView = itemView.findViewById<ImageView>(R.id.imageView)
    val mdate = itemView.findViewById<TextView>(R.id.date)
    val mauthor = itemView.findViewById<TextView>(R.id.author)
    val cd_view = itemView.findViewById<CardView>(R.id.cd_view)


}
