package com.example.dmovgetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.dmovgetrequest.databinding.ActivityMainBinding
import org.json.JSONObject
import java.time.temporal.TemporalAmount

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var queue: RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        queue = Volley.newRequestQueue(this)
        //getPokemonList(5)
        var cuantos: Int
                binding.btnUpdate.setOnClickListener{
                    cuantos = binding.etPokeAmount.text.toString().toInt()
                    getPokemonList(cuantos)
                }


    }

    fun getPokemonList(listAmount: Int){
        val url = "https://pokeapi.co/api/v2/pokemon/?limit=${listAmount}"

        val jsonRequest = JsonObjectRequest(url, Response.Listener<JSONObject>{ response ->
            Log.i("JSONRESPONSE", response.getJSONArray("results").toString())
        },
        Response.ErrorListener { error ->
            Log.w("JSONRESPONSE", error.message as String)
        })

        queue.add(jsonRequest)

    }

    override fun onStop(){
        super.onStop()
        queue.cancelAll("Stopped")
    }

}