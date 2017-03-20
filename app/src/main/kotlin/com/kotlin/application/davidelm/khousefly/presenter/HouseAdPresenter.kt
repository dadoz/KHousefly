package com.kotlin.application.davidelm.khousefly.presenter

import android.app.Activity
import android.util.Log
import android.util.SparseArray
import com.kotlin.application.davidelm.khousefly.manager.RetrofitManager
import com.kotlin.application.davidelm.khousefly.model.HouseAd
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference
import java.util.ArrayList

class HouseAdPresenter(activityRef: WeakReference<Activity>, params : SparseArray<String>?) : BasePresenter {
    override fun onFinishedRetrieveItems(list: ArrayList<*>) {
        Log.e("TAG", list[0].toString())
    }

    override fun onError(message: String?) {
    }

    init {
        Interactor().retrieveItems(WeakReference(this), params)
    }

    class Interactor : BaseInteractor {
        private var disposable: Disposable? = null

        override fun unbindSubscription() {
            disposable?.dispose()
        }


        override fun retrieveItems(listener: WeakReference<BasePresenter>, params: SparseArray<String>?) {
            disposable = RetrofitManager()
                    .instance.service
                    ?.getHouseAd(params?.get(0), params?.get(1))
                    ?.filter({ list -> list != null })
                    ?.switchIfEmpty(Observable.just(ArrayList<HouseAd>()))
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeWith(object : DisposableObserver<ArrayList<HouseAd>>() {
                        override fun onComplete() {
                        }

                        override fun onNext(value: ArrayList<HouseAd>) {
                            listener.get()!!.onFinishedRetrieveItems(value)
                        }

                        override fun onError(e: Throwable) {
                            e.printStackTrace()
                            listener.get()!!.onError(e.message)

                        }
                    })
        }

    }
}

