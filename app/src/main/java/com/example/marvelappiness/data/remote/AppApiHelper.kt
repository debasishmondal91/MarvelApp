package com.example.marvelappiness.data.remote

import com.example.marvelappiness.data.model.MarvelResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by debasish on 20/03/20.
 */
@Singleton
class AppApiHelper @Inject constructor() : ApiHelper {
    override fun doGetMarvelApiCall(): Single<List<MarvelResponse>> {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_MARVEL)
            .build()
            .getObjectListSingle(MarvelResponse::class.java)
    }
}