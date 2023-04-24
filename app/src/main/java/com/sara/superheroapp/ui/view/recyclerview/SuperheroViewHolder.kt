package com.sara.superheroapp.ui.view.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sara.superheroapp.databinding.ItemSuperheroBinding
import com.sara.superheroapp.domain.model.SuperheroItem
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItem: SuperheroItem, onItemSelected: (String) -> Unit){
        binding.tvSuperheroName.text = superheroItem.name

        Picasso.get().load(superheroItem.image.url).into(binding.ivSuperhero)
        binding.root.setOnClickListener { onItemSelected(superheroItem.id) }
    }
}