package com.sara.superheroapp.ui.view.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sara.superheroapp.R
import com.sara.superheroapp.databinding.ItemSuperheroBinding
import com.sara.superheroapp.domain.model.SuperheroItem
import com.squareup.picasso.Picasso
import javax.inject.Inject

class SuperheroViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)
    companion object{// TODO LA LISTA NO FUNCIONA, CUANDO VUELVO A ESCRIBIR SE QUITA EL CORAZON Y SE PONE A DISABLED
        val favorites: MutableList<String> = mutableListOf()
    }

    fun bind(superheroItem: SuperheroItem, onItemSelected: (String) -> Unit, favSuperhero: (SuperheroItem) -> Unit, unfavSuperhero: (String) -> Unit){
        binding.tvSuperheroName.text = superheroItem.name

        Picasso.get().load(superheroItem.image.url).into(binding.ivSuperhero)

        if(favorites.contains(superheroItem.id)) binding.favIcon.setImageResource(R.drawable.ic_favorite_enabled)
        else binding.favIcon.setImageResource(R.drawable.ic_favorite_disabled)

        binding.favIcon.setOnClickListener {
            if(favorites.contains(superheroItem.id)){
                binding.favIcon.setImageResource(R.drawable.ic_favorite_disabled)
                unfavSuperhero(superheroItem.id)
                //favorites.remove(superheroItem.id)
            }else{
                binding.favIcon.setImageResource(R.drawable.ic_favorite_enabled)
                //favorites.add(superheroItem.id)
                favSuperhero(superheroItem)
            }
        }

        binding.root.setOnClickListener { onItemSelected(superheroItem.id) }
    }
}