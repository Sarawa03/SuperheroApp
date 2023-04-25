package com.sara.superheroapp.ui.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sara.superheroapp.R
import com.sara.superheroapp.domain.model.SuperheroItem
import javax.inject.Inject

class SuperheroAdapter @Inject constructor(
    var superheroList: List<SuperheroItem> = emptyList(),
    private val onItemSelected: (String) -> Unit,
    private val addFavHero: (SuperheroItem) -> Unit,
    private val unfavHero: (String) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroList: List<SuperheroItem>) {
        this.superheroList = superheroList

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {

        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }

    override fun onBindViewHolder(viewHolder: SuperheroViewHolder, position: Int) {

        viewHolder.bind(superheroList[position], onItemSelected, addFavHero, unfavHero)
    }

}