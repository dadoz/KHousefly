package com.kotlin.application.davidelm.khousefly.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kotlin.application.davidelm.khousefly.R
import com.kotlin.application.davidelm.khousefly.model.HouseAd
import java.lang.ref.WeakReference

class HouseAdAdapter(list: ArrayList<*>, listener: WeakReference<OnSelectedItemClickListener>) : RecyclerView.Adapter<HouseAdAdapter.ViewHolder>() {
    private var list: ArrayList<*> = list
    private val lst: WeakReference<OnSelectedItemClickListener>? = listener

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        var item = list[position] as HouseAd
        holder?.titleView?.text = item.title
        holder?.descriptionView?.text = item.description
        holder?.agencyText?.text = item.agency
        holder?.priceView?.text = String.format(holder?.itemView?.context
                ?.getString(R.string.price_placeholder).toString(), item.price)
        Glide.with(holder?.itemView?.context).load(item.photo).into(holder?.previewView)
        holder?.itemView?.setOnClickListener { view -> lst?.get()?.onClickItem(view, position) }
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
        val titleView = view.findViewById(R.id.titleTextId) as TextView
        val descriptionView = view.findViewById(R.id.descriptionTextId) as TextView
        val agencyText = view.findViewById(R.id.agencyTextId) as TextView
        val priceView = view.findViewById(R.id.priceTextId) as TextView
        val previewView = view.findViewById(R.id.previewImageId) as ImageView
    }
}

interface OnSelectedItemClickListener {
    fun onClickItem(view : View , position: Int)
}
