package com.example.kotlinkoinmvvm.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinkoinmvvm.Model.Cat
import com.example.kotlinkoinmvvm.R
import kotlinx.android.synthetic.main.item_cat.view.*

class CatAdapter(var catsList: List<Cat>) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    // This is a method that create the viewHolder which will have the card that will contain
    // the imageView which is our component that will appear to the user
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    // this function used to know what is the number elements
    override fun getItemCount(): Int = catsList.size

    // This is a method that will bind the data from each element list into its respective place in
    // the recyclerView
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // Verify if position exists in list to avoid IndexOutOfBoundException
        val cat: Cat = catsList[position]

        // Glide is image library that is used to fetch images from url and put them into our imageView
        Glide.with(holder.itemView.context)
            .load(cat.imageUrl)
            .centerCrop()
            .thumbnail()
            .into(holder.itemCatImageView)
    }

    // Update recyclerView's data when we get it from our API
    fun updateData(newCatsList: List<Cat>) {
        catsList = newCatsList
        // tell the recyclerView that it's list has been changed and it needs to be updated
        notifyDataSetChanged()
    }

    // ViewHolder that would have an ImageView that would changed depending on which item needs to be drawn in it
    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemCatImageView = itemView.itemCatImageView
    }
}