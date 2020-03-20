package com.example.marvelappiness.data.remote;


import com.example.marvelappiness.data.model.MarvelResponse;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by debasish on 20/03/20.
 */

public interface ApiHelper {

    Single<List<MarvelResponse>> doGetMarvelApiCall();
}
