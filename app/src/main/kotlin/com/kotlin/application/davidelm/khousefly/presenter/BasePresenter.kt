package com.kotlin.application.davidelm.khousefly.presenter

import java.util.ArrayList

interface BasePresenter {
    fun onFinishedRetrieveItems(list: ArrayList<*>)
    fun onError(message: String?)
}