package com.kotlin.application.davidelm.khousefly.presenter

import android.util.SparseArray
import java.lang.ref.WeakReference

interface BaseInteractor {
    fun unbindSubscription()

    fun retrieveItems(listener: WeakReference<BasePresenter>, params: SparseArray<String>?)
}