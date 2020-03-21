package com.example.marvelappiness.ui.main

import android.app.AlertDialog
import android.util.Log
import com.example.marvelappiness.data.DataManager
import com.example.marvelappiness.data.model.MarvelResponse
import com.example.marvelappiness.ui.base.BaseViewModel
import com.example.marvelappiness.utils.rx.SchedulerProvider

class MarvelViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<MarvelNavigator>(dataManager, schedulerProvider) {

    fun getMarvel(marvelActivity: MarvelActivity) {
        if (marvelActivity.isNetworkConnected) {

            compositeDisposable.add(dataManager.doGetMarvelApiCall()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({ t: MutableList<MarvelResponse>? ->
                    if (t != null) {
                        navigator!!.updateUI(t)
                    }

                }) {
                    it.printStackTrace()
                })
        } else {
            try {
                val alertDialog: AlertDialog = AlertDialog.Builder(marvelActivity).create()
                alertDialog.setTitle("Info")
                alertDialog.setMessage("Internet not available, Please check your internet connectivity and try again")
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert)
                alertDialog.setButton(
                    "OK"
                ) { _, _ -> marvelActivity.finish() }
                alertDialog.show()
            } catch (e: Exception) {
                Log.d("LOG", "Show Dialog: " + e.message)
            }
        }

    }
}