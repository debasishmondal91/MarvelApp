package com.example.marvelappiness.data;

import android.content.Context;

import com.example.marvelappiness.data.model.MarvelResponse;
import com.example.marvelappiness.data.remote.ApiHelper;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by debasish on 20/03/20.
 */
@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final Gson mGson;


    @Inject
    public AppDataManager(Context context, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mApiHelper = apiHelper;
        mGson = gson;
    }


    @Override
    public Single<List<MarvelResponse>> doGetMarvelApiCall() {
        return mApiHelper.doGetMarvelApiCall();
    }
}
