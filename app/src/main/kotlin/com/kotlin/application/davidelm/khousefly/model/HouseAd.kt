package com.kotlin.application.davidelm.khousefly.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class HouseAd {
    @SerializedName("description")
    @Expose
    var description : String? = null
    @SerializedName("title")
    @Expose
    var title : String? = null
    @SerializedName("url")
    @Expose
    var url : String? = null
    @SerializedName("photo")
    @Expose
    var photo : String? = null
    @SerializedName("agency")
    @Expose
    var agency : String? = null
    @SerializedName("meta")
    @Expose
    var meta : String? = null
    @SerializedName("price")
    @Expose
    var price : String? = null

}