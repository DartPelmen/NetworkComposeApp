package edu.festu.ivankuznetsov.networkcomposeapp.network


import edu.festu.ivankuznetsov.networkcomposeapp.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/*
* API для взаимодействия. Поставляется одиночке для работы.
* ОБРАТИТЕ ВНИМАНИЕ, функция getAllPosts - suspend!
* */
interface PostAPI {
    @GET("todos/")
    suspend fun getAllPosts() :List<Post>

}