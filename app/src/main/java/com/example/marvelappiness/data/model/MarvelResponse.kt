package com.example.marvelappiness.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MarvelResponse {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("num.backers")
    @Expose
    var numBackers: String? = null
    @SerializedName("by")
    @Expose
    var by: String? = null
}