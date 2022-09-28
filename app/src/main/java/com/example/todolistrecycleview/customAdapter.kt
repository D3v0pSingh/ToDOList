package com.example.todolistrecycleview

import android.content.pm.PackageManager
import android.util.Property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.singleitem.view.*

class customAdapter(private val list: MutableList<Data>,
                    private val listener: onItemCLickListener
)
    : RecyclerView.Adapter<customAdapter.itemsViewHolder>(){

    inner class itemsViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val delete: ImageView = itemview.imageView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemsViewHolder {
        val inflater:LayoutInflater = LayoutInflater.from(parent.context)
        val view:View = inflater.inflate(R.layout.singleitem,null)
        return itemsViewHolder(view)
    }
    override fun onBindViewHolder(holder: itemsViewHolder, position: Int) {
        holder.itemView.apply {
            itemtextview.text = list[position].name
        }
        holder.delete.setOnClickListener {
            if (position != RecyclerView.NO_POSITION){
            listener.onItemClick(position)}
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    interface onItemCLickListener{
        fun onItemClick(position: Int)
    }

}