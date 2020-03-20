package com.example.marvelappiness.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelappiness.R
import com.example.marvelappiness.ViewModelProviderFactory
import com.example.marvelappiness.data.model.MarvelResponse
import com.example.marvelappiness.databinding.ActivityMarvelBinding
import com.example.marvelappiness.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_marvel.*
import javax.inject.Inject


class MarvelActivity : BaseActivity<ActivityMarvelBinding, MarvelViewModel>(), MarvelNavigator {

    @set:Inject
    internal var factory: ViewModelProviderFactory? = null
    private var marvelViewModel: MarvelViewModel? = null
    private var mMarvelAdapter: MarvelAdapter? = null
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        marvelViewModel!!.navigator = this
        marvelViewModel!!.getMarvel(this)

        setUp()
    }

    private fun setUp() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun getBindingVariable(): Int {
        return com.example.marvelappiness.BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_marvel
    }

    override fun getViewModel(): MarvelViewModel {
        marvelViewModel = ViewModelProviders.of(this, factory).get(MarvelViewModel::class.java)
        return marvelViewModel as MarvelViewModel
    }

    @SuppressLint("WrongConstant")
    override fun updateUI(resp: MutableList<MarvelResponse>) {

        val sortedAppsList = resp.sortedBy { it.title.toString() }
        recycler_marvel.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        mMarvelAdapter = MarvelAdapter(this, sortedAppsList)
        recycler_marvel.adapter = mMarvelAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val mSearch: MenuItem = menu.findItem(R.id.action_search)
        val mSearchView: SearchView = mSearch.actionView as SearchView
        mSearchView.queryHint = "Search"
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mMarvelAdapter!!.filter!!.filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}