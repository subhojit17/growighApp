package com.example.growighapp

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerviewAdapter :RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>(){
    val imageItems = mutableListOf<ImageData>()
    fun setImages(items: List<ImageData>) {
        Log.d("getnews", "setNewsItems: news list size "+ imageItems.size)
        imageItems.clear()
        imageItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerviewAdapter.ViewHolder, position: Int) {
        val currentItem = imageItems[position]
        val author_title = "Author - ${currentItem.author}"
        holder.imageAuthor.text = author_title
        Glide.with(holder.itemView.context).load(currentItem.url).into(holder.imageView);
    }

    override fun getItemCount(): Int {
    return imageItems.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageAuthor: TextView = view.findViewById(R.id.image_author)
        val imageView: ImageView = view.findViewById(R.id.image_view)
    }
}
