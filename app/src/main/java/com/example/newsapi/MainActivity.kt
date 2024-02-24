package com.example.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.newsapi.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : DemoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiKey = "2bb3cc6d93344f4e80353af1c59bc9b0"

        GlobalScope.launch {
            try {
                val bearerToken = "Bearer $apiKey"
                val result = ApiClient.apiService.getNews(bearerToken)
                if(result.body()!= null){
                    Log.e("body", result.body().toString() )
                    adapter = DemoAdapter(this@MainActivity,result.body()!!.articles)
                    binding.rlView.adapter = adapter
                }else{
                    Toast.makeText(this@MainActivity,"there is an error",Toast.LENGTH_SHORT).show()
                }
            }catch (e: Exception){

            }
        }

    }
}