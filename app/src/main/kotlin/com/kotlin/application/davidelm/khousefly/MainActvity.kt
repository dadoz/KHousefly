package com.kotlin.application.davidelm.khousefly

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlin.application.davidelm.khousefly.application.KHouseFlyApplication
import com.kotlin.application.davidelm.khousefly.views.PlaceChooserView
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    private var placeChooserView: PlaceChooserView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        placeChooserView = findViewById(R.id.placeChooserViewId) as PlaceChooserView?

        //set listener
        placeChooserView?.setListener(WeakReference(View.OnClickListener {
            (application as KHouseFlyApplication)
                    .setParams(placeChooserView?.getPlace(), placeChooserView?.getFilter())
            startActivity(Intent(this, HouseAdListActivity::class.java))
        }))
    }
}