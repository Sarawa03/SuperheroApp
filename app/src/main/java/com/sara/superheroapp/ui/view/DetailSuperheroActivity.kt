package com.sara.superheroapp.ui.view

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.sara.superheroapp.databinding.ActivityDetailSuperheroBinding
import com.sara.superheroapp.domain.model.PowerStatsResponse
import com.sara.superheroapp.domain.model.SuperheroDetails
import com.sara.superheroapp.ui.viewmodel.SuperheroDetailsViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt
@AndroidEntryPoint //cannot instance error
class DetailSuperheroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    private lateinit var  binding: ActivityDetailSuperheroBinding
    private val superheroDetailsViewModel: SuperheroDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        superheroDetailsViewModel.postSuperheroDetails(id)

        superheroDetailsViewModel.superHeroDetailsModel.observe(this, Observer {
            createUI(it)
        })

    }

    private fun createUI(superhero: SuperheroDetails) {
        Picasso.get().load(superhero.image.url).into(binding.ivSuperhero)
        binding.tvSuperHeroName.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperHeroRealName.text = superhero.biography.fullName
        binding.tvPublisher.text = superhero.biography.publisher
    }

    private fun prepareStats(powerstats: PowerStatsResponse){
        binding.viewCombat
        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewDurability, powerstats.durability)
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewPower, powerstats.power)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewStrength, powerstats.strength)

    }

    private fun updateHeight(view: View, stat:String){
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }

    private fun pxToDp(px:Float):Int{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, resources.displayMetrics).roundToInt()
    }


}