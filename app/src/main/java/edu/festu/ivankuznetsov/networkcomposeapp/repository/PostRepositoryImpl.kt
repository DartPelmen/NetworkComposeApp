package edu.festu.ivankuznetsov.networkcomposeapp.repository

import edu.festu.ivankuznetsov.networkcomposeapp.model.Post
import edu.festu.ivankuznetsov.networkcomposeapp.network.PostAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
/*
* Будем брать посты с сетевого ресурса и паковать во flow
* */
class PostRepositoryImpl(private val retrofit: Retrofit) : PostRepository {
    override fun getAllPosts(): Flow<List<Post>> =
        flow { emit(retrofit.create(PostAPI::class.java).getAllPosts()) }
}