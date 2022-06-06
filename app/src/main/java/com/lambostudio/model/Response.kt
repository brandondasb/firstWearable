package com.lambostudio.model
import java.io.Serializable

data class Response(val success: Boolean,val body:List<Joke>): Serializable {


}
data class Joke(
    val id:String,
    val type: String,
    val setup: String,
    val punchline:String,
    val likes: List<String>,
): Serializable