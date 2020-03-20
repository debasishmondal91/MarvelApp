package com.example.marvelappiness.di.builder;


import com.example.marvelappiness.ui.main.MarvelActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by debasish on 20/03/20.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MarvelActivity marvelActivity();

}
