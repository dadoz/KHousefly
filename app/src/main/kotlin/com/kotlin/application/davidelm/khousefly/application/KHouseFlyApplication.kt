package com.kotlin.application.davidelm.khousefly.application

import android.app.Application
import android.util.SparseArray

class KHouseFlyApplication : Application() {
    private var params: SparseArray<String> = SparseArray<String>()
    init {
    }

    fun getParams(): SparseArray<String>? {
        return params
    }

    fun setParams(params: SparseArray<String>) {
        this.params = params
    }

    fun setParams(place: String?, filter: String?) {
        params.put(0, place)
        params.put(1, filter)
    }
}