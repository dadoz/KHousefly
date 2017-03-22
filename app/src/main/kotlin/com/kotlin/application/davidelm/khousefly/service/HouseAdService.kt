package com.kotlin.application.davidelm.khousefly.service

import com.kotlin.application.davidelm.khousefly.model.HouseAd
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList

interface HouseAdService {
//    @GET("repos/{owner}/{repo}/stargazers")
//    fun getHouseAd(@Path("owner") owner: String?, @Path("repo") repo: String?): Observable<ArrayList<HouseAd>>
    @GET("quarters")
    fun getQuarters() : Observable<ArrayList<String>>
    @GET("ads/{quarters}")
    fun getAds(@Path("quarters") quarters : String) : Observable<ArrayList<HouseAd>>

    //entry point already deployed
    //https://gentle-forest-4517.herokuapp.com/quarters
    //https://gentle-forest-4517.herokuapp.com/ads?quarters=58
}
