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

        binding.favIcon.setOnClickListener {
            if(superheroItem.isFav){
                binding.favIcon.setImageResource(R.drawable.ic_favorite_disabled)
                unfavSuperhero(superheroItem.id)
                superheroItem.isFav = !superheroItem.isFav

            }else{
                binding.favIcon.setImageResource(R.drawable.ic_favorite_enabled)
                superheroItem.isFav = !superheroItem.isFav
                favSuperhero(superheroItem)

            }

        }

        binding.root.setOnClickListener { onItemSelected(superheroItem.id) }
    }
}