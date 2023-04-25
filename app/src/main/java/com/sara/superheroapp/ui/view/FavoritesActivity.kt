package com.sara.superheroapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sara.superheroapp.databinding.ActivityFavoritesBinding
import com.sara.superheroapp.domain.model.SuperheroItem
import com.sara.superheroapp.ui.view.recyclerview.FavSuperheroAdapter
import com.sara.superheroapp.ui.view.recyclerview.SuperheroAdapter
import com.sara.superheroapp.ui.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoritesBinding
    private val superheroViewModel: FavoritesViewModel by viewModels()
    private lateinit var adapter: FavSuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FavSuperheroAdapter (onItemSelected = {navigateToDetail(it)}, addFavHero = {addFavToDatabase(it)}, unfavHero = {unfavHero(it)})
        binding.rvSuperhero.adapter = adapter

        superheroViewModel.showFavs()

        superheroViewModel.superHeroModel.observe(this, Observer {
            adapter.updateList(it)

        })


    }

    private fun navigateToDetail(id: String) {
        Log.i("HELLO WORLD", id.toString())
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(DetailSuperheroActivity.EXTRA_ID, id)
        startActivity(intent)

    }

    private fun addFavToDatabase(superheroItem: SuperheroItem){
        superheroViewModel.addFavHero(superheroItem)
    }

    private fun unfavHero(superheroItem: String){
        superheroViewModel.unfavHero(superheroItem)
    }
}