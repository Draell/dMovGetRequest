package com.example.dmovgetrequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dmovgetrequest.databinding.ItemPokemonesBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val pokemones: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemPokemonesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(pokemones.getJSONObject(position))
    }

    override fun getItemCount(): Int = pokemones.length()

    class MainHolder(val binding: ItemPokemonesBinding): RecyclerView.ViewHolder(binding.root){
        fun render(pokemon: JSONObject){
            binding.tvPokemones.setText(pokemon.getString("name"))
        }
    }
}