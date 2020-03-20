package com.example.marvelappiness

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.example.marvelappiness.data.DataManager
import com.example.marvelappiness.ui.main.MarvelViewModel
import com.example.marvelappiness.utils.rx.SchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by debasish on 20/03/20.
 */
@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val dataManager: DataManager,
    private val schedulerProvider: SchedulerProvider
) : NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MarvelViewModel::class.java)) {
            return MarvelViewModel(dataManager, schedulerProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}