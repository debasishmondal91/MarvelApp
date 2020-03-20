package com.example.marvelappiness.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelappiness.R
import com.example.marvelappiness.data.model.MarvelResponse
import kotlinx.android.synthetic.main.list_marvel_row.view.*
import java.util.ArrayList

class MarvelAdapter() :
    RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>(), Filterable {

    private var countryList: List<MarvelResponse>? = null
    private var countryListFiltered: List<MarvelResponse>? = null
    private var context: MarvelActivity? = null

    constructor(context: MarvelActivity, list: List<MarvelResponse>) : this() {
        this.context = context
        this.countryList = list
        this.countryListFiltered = list
    }

    class MarvelViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.title
        val numOfBackers: TextView = itemView.num_of_backers
        val by: TextView = itemView.by
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                countryListFiltered = if (charString.isEmpty()) {
                    countryList
                } else {
                    val filteredList: MutableList<MarvelResponse> =
                        ArrayList<MarvelResponse>()
                    for (row in countryList!!) {
                        if (row.title!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = countryListFiltered
                return filterResults
            }

            override fun publishResults(
                constraint: CharSequence,
                filterResults: FilterResults
            ) {
                try {
                    countryListFiltered = filterResults.values as ArrayList<MarvelResponse>
                    notifyDataSetChanged()
                } catch (e: Exception) {
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_marvel_row, parent, false)
        return MarvelViewHolder(view)
    }


    override fun getItemCount(): Int {
        return countryListFiltered!!.size
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        holder.title.text = countryListFiltered!![position].title
        holder.numOfBackers.text = countryListFiltered!![position].numBackers
        holder.by.text = countryListFiltered!![position].by
    }
}