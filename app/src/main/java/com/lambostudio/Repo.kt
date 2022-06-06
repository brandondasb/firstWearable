package com.lambostudio

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.coroutines.CoroutineContext

class Repo {

    fun getRandomJoke(){
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(uri)
            .get()
            .addHeader("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "f32ac7167cmshd653eb0e707d48fp1b8ee6jsnd3d53c56307c")
            .build()

        val response = client.newCall(request).execute()
        request.body.let {
            Log.i("###",it.toString())
        }

    }
    companion object {
        const val  uri ="https://dad-jokes.p.rapidapi.com/random/joke"
    }
}