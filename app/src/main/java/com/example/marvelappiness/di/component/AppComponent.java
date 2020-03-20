package com.example.marvelappiness.di.component;

import android.app.Application;

import com.example.marvelappiness.MarvelApp;
import com.example.marvelappiness.di.builder.ActivityBuilder;
import com.example.marvelappiness.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by debasish on 20/03/20.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MarvelApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
