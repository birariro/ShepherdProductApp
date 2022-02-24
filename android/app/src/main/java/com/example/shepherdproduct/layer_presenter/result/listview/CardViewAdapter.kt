package com.example.shepherdproduct.layer_presenter.result.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shepherdproduct.R
import com.example.shepherdproduct.layer_domain.data.SearchData

class CardViewAdapter : RecyclerView.Adapter<CardViewAdapter.ViewHolder>(){

    private lateinit var searchData :SearchData
    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var company_text_view: TextView = itemView.findViewById(R.id.company_text_view)
        var product_text_view: TextView = itemView.findViewById(R.id.product_text_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent,false)
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.company_text_view.text = searchData.data[position].company
        holder.product_text_view.text = searchData.data[position].product

    }

    override fun getItemCount(): Int {
        return searchData.data.size
    }

    fun setData(searchData : SearchData){
        this.searchData = searchData
        notifyDataSetChanged()
    }
}