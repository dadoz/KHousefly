package com.kotlin.application.davidelm.khousefly

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.SparseArray
import android.view.View
import com.kotlin.application.davidelm.khousefly.application.KHouseFlyApplication
import com.kotlin.application.davidelm.khousefly.presenter.HouseAdPresenter
import java.lang.ref.WeakReference

class HouseAdListActivity : AppCompatActivity() {
    var progressbar : View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.house_ad_list_layout)
        initView()
    }

    private fun initView() {
        progressbar = findViewById(R.id.houseAdListProgressbarId)
        HouseAdPresenter(WeakReference(this), (application as KHouseFlyApplication).getParams())
    }

}