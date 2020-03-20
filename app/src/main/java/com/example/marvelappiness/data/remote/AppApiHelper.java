package com.example.marvelappiness.data.remote;


import com.example.marvelappiness.data.model.MarvelResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by debasish on 20/03/20.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {

    }


    @Override
    public Single<List<MarvelResponse>> doGetMarvelApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_MARVEL)
                .build()
                .getObjectListSingle(MarvelResponse.class);
    }
}
