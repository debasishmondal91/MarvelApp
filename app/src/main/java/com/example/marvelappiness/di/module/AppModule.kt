package com.example.marvelappiness.di.module

import android.app.Application
import android.content.Context
import com.example.marvelappiness.data.AppDataManager
import com.example.marvelappiness.data.DataManager
import com.example.marvelappiness.data.remote.ApiHelper
import com.example.marvelappiness.data.remote.AppApiHelper
import com.example.marvelappiness.utils.rx.AppSchedulerProvider
import com.example.marvelappiness.utils.rx.SchedulerProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by debasish on 20/03/20.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

}