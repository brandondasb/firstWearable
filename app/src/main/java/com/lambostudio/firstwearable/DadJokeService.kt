package com.lambostudio.firstwearable

import com.lambostudio.model.Joke
import com.lambostudio.model.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokeService {
    @Headers("X-RapidAPI-Key: f32ac7167cmshd653eb0e707d48fp1b8ee6jsnd3d53c56307c")
    @GET("joke")
    fun getRandomJoke(): Call<Response>

    companion object {
        const val BASE_URL = "https://dad-jokes.p.rapidapi.com/random/"

        fun create(): DadJokeService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)

                .build()
            return retrofit.create(DadJokeService::class.java)
        }
    }
}