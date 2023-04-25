package com.sara.superheroapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager


import com.sara.superheroapp.ui.view.DetailSuperheroActivity.Companion.EXTRA_ID
import com.sara.superheroapp.databinding.ActivityMainBinding
import com.sara.superheroapp.domain.model.SuperheroItem
import com.sara.superheroapp.ui.view.recyclerview.SuperheroAdapter
import com.sara.superheroapp.ui.viewmodel.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val superheroViewModel: SuperheroViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SuperheroAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()

        superheroViewModel.superHeroModel.observe(this, Observer {

            adapter.updateList(it)
            binding.progressBar.isVisible = false
        })

    }

    private fun initUi() {

        //binding.rvSuperhero.favIcon

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {//Cuando pulsamos en buscar, la lupa
                binding.progressBar.isVisible = true
                superheroViewModel.searchSuperheroByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {//Se llama a medida que vamos escribiendo
                binding.progressBar.isVisible = true
                superheroViewModel.searchSuperheroByName(query.orEmpty())
                return false
            }
        })
        adapter = SuperheroAdapter (onItemSelected = {navigateToDetail(it)}, addFavHero = {addFavToDatabase(it)}, unfavHero = {unfavHero(it)})
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }


    private fun navigateToDetail(id: String) {
        Log.i("HELLO WORLD", id.toString())
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)

    }

    private fun addFavToDatabase(superheroItem: SuperheroItem){
        superheroViewModel.addFavHero(superheroItem)
    }

    private fun unfavHero(superheroItem: String){
        superheroViewModel.unfavHero(superheroItem)
    }
}