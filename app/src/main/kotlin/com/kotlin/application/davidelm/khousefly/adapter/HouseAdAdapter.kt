package com.kotlin.application.davidelm.khousefly.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import com.kotlin.application.davidelm.khousefly.R
import com.kotlin.application.davidelm.khousefly.model.HouseAd

class HouseAdAdapter(list: ArrayList<*>) : RecyclerView.Adapter<HouseAdAdapter.ViewHolder>() {
    private var list: ArrayList<*> = list

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.titleViewId?.text = (list[position] as HouseAd).title
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HouseAdAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.house_ad_item, parent, false)
        return HouseAdAdapter.ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleViewId = view.findViewById(R.id.titleTextId) as TextView
    }
}