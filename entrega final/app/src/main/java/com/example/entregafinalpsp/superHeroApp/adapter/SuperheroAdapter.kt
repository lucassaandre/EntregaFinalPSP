package com.example.entregafinalpsp.superHeroApp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.entregafinalpsp.R
import com.example.entregafinalpsp.superHeroApp.model.SuperheroItemResponse

class SuperheroAdapter(
    var superheroList: List<SuperheroItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(list: List<SuperheroItemResponse>) {
        superheroList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        viewholder.bind(superheroList[position],onItemSelected)
    }

    override fun getItemCount() = superheroList.size


}