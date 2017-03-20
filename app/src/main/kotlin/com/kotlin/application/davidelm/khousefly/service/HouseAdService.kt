package com.kotlin.application.davidelm.khousefly.service

import com.kotlin.application.davidelm.khousefly.model.HouseAd
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.ArrayList

interface HouseAdService {
    @GET("repos/{owner}/{repo}/stargazers")
    fun getHouseAd(@Path("owner") owner: String?, @Path("repo") repo: String?): Observable<ArrayList<HouseAd>>

}
