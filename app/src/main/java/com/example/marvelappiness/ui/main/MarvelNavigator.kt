package com.example.marvelappiness.ui.main

import com.example.marvelappiness.data.model.MarvelResponse

interface MarvelNavigator {

    fun updateUI(resp: MutableList<MarvelResponse>)
}