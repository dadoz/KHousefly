package com.kotlin.application.davidelm.khousefly

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.AdapterView
import com.kotlin.application.davidelm.khousefly.adapter.HouseAdAdapter
import com.kotlin.application.davidelm.khousefly.adapter.OnSelectedItemClickListener
import com.kotlin.application.davidelm.khousefly.application.KHouseFlyApplication
import com.kotlin.application.davidelm.khousefly.model.HouseAd
import com.kotlin.application.davidelm.khousefly.presenter.HouseAdPresenter
import java.lang.ref.WeakReference
import java.util.ArrayList

class HouseAdListActivity : AppCompatActivity(), HouseAdView, OnSelectedItemClickListener {
    var progressbar : View? = null
    private var recyclerView: RecyclerView ? = null
    val TAG: String = "HouseAdListActivity"
    override fun onError(message: String?) {
        Log.e(TAG, message)
        progressbar?.visibility = View.GONE
        Snackbar.make(findViewById(R.id.houseAdLayoutId), "Oh Snap! " + message, Snackbar.LENGTH_LONG).show()
    }

    override fun onRetrieveItems(list: ArrayList<*>) {
        progressbar?.visibility = View.GONE
//        Log.e(TAG, (list.get(0) as HouseAd).title)
        recyclerView?.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView?.adapter = HouseAdAdapter(list, WeakReference(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.house_ad_list_layout)
        initView()
    }


    private fun initView() {
        progressbar = findViewById(R.id.houseAdListProgressbarId)
        recyclerView = findViewById(R.id.houseAdRecyclerViewId) as RecyclerView
        HouseAdPresenter(WeakReference(this), (application as KHouseFlyApplication).getParams())
    }

    override fun onClickItem(view: View, position: Int) {
        Log.e(TAG, "hey " + position)
    }


}

interface HouseAdView {
    fun onRetrieveItems(list: ArrayList<*>)
    fun onError(message: String?)
}
