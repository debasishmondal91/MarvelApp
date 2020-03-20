package com.example.marvelappiness;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.marvelappiness.data.DataManager;
import com.example.marvelappiness.ui.main.MarvelViewModel;
import com.example.marvelappiness.utils.rx.SchedulerProvider;;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by debasish on 20/03/20.
 */

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

  private final DataManager dataManager;
  private final SchedulerProvider schedulerProvider;

  @Inject
  public ViewModelProviderFactory(DataManager dataManager,
      SchedulerProvider schedulerProvider) {
    this.dataManager = dataManager;
    this.schedulerProvider = schedulerProvider;
  }


  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
    if (modelClass.isAssignableFrom(MarvelViewModel.class)) {
      //noinspection unchecked
      return (T) new MarvelViewModel(dataManager,schedulerProvider);
    }

    throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
  }
}