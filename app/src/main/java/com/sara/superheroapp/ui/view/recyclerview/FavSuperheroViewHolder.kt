package com.sara.superheroapp.ui.view.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sara.superheroapp.R
import com.sara.superheroapp.databinding.ItemSuperheroBinding
import com.sara.superheroapp.domain.model.SuperheroItem
import com.squareup.picasso.Picasso

class FavSuperheroViewHolder (view: View): RecyclerView.ViewHolder(view) {


    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItem: SuperheroItem, onItemSelected: (String) -> Unit, favSuperhero: (SuperheroItem) -> Unit, unfavSuperhero: (String) -> Unit){
        binding.tvSuperheroName.text = superheroItem.name

        Log.i("PATATA", superheroItem.name)

        Picasso.get().load(superheroItem.image.url).into(binding.ivSuperhero)
        Log.i("PATATA", "LISTA FAVORITOS LISTADO FAV: "+ SuperheroViewHolder.favorites.toString())
        Log.i("PATATA", "ID EN LISTA FAV: "+ superheroItem.id)
        if(SuperheroViewHolder.favorites.contains(superheroItem.id)) binding.favIcon.setImageResource(R.drawable.ic_favorite_enabled)
        else binding.favIcon.setImageResource(R.drawable.ic_favorite_disabled)

        binding.favIcon.setOnClickListener {
            if(SuperheroViewHolder.favorites.contains(superheroItem.id)){
                binding.favIcon.setImageResource(R.drawable.ic_favorite_disabled)
                unfavSuperhero(superheroItem.id)
                SuperheroViewHolder.favorites.remove(superheroItem.id)

            }else{
                binding.favIcon.setImageResource(R.drawable.ic_favorite_enabled)
                SuperheroViewHolder.favorites.add(superheroItem.id)
                favSuperhero(superheroItem)
            }

        }

        binding.root.setOnClickListener { onItemSelected(superheroItem.id) }
    }
}