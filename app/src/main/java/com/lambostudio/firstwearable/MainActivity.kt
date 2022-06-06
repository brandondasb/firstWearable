package com.lambostudio.firstwearable

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lambostudio.Repo
import com.lambostudio.firstwearable.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var repo: Repo
    val apiInterface = DadJokeService.create().getRandomJoke()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repo = Repo()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getNewJoke()

        binding.revealPunchline.setOnClickListener {
            binding.jokePunchline.visibility = View.VISIBLE
            binding.revealPunchline.visibility = View.GONE
            binding.anotherOne.visibility =View.VISIBLE
        }
        binding.anotherOne.setOnClickListener {

            binding.revealPunchline.visibility = View.GONE
            getNewJoke()
        }

    }

    private fun getNewJoke() {
        apiInterface.enqueue(object : Callback<com.lambostudio.model.Response> {
            override fun onResponse(
                call: Call<com.lambostudio.model.Response>,
                response: Response<com.lambostudio.model.Response>
            ) {
                if (response.body() != null) {
                    binding.jokeSetup.text =
                        response.body()?.body?.get(0)?.setup ?: "could not get a joke this time"
                    binding.jokePunchline.text =
                        response.body()?.body?.get(0)?.punchline ?: "argh i Forgot the punchLine"
                }
            }

            override fun onFailure(call: Call<com.lambostudio.model.Response>, t: Throwable) {
                Log.i("£££", t.message.toString())
            }
        })
    }

}

