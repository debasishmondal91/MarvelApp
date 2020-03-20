package com.example.marvelappiness.data.remote

import com.example.marvelappiness.data.model.MarvelResponse
import io.reactivex.Single

/**
 * Created by debasish on 20/03/20.
 */
interface ApiHelper {
    fun doGetMarvelApiCall(): Single<List<MarvelResponse?>?>?
}