package com.example.entregafinalpsp.superHeroApp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.entregafinalpsp.databinding.ItemSuperheroBinding
import com.example.entregafinalpsp.superHeroApp.model.SuperheroItemResponse
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = superheroItemResponse.name
        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)
        binding.root.setOnClickListener { onItemSelected(superheroItemResponse.superheroId) }
    }
}