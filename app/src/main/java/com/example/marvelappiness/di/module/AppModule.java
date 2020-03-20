package com.example.marvelappiness.di.module;

import android.app.Application;
import android.content.Context;
import com.example.marvelappiness.data.AppDataManager;
import com.example.marvelappiness.data.DataManager;
import com.example.marvelappiness.data.remote.ApiHelper;
import com.example.marvelappiness.data.remote.AppApiHelper;
import com.example.marvelappiness.utils.rx.AppSchedulerProvider;
import com.example.marvelappiness.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by debasish on 20/03/20.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
