package edu.festu.ivankuznetsov.networkcomposeapp.repository

import edu.festu.ivankuznetsov.networkcomposeapp.model.Post
import kotlinx.coroutines.flow.Flow

/*
* Интерфейс, описывающий, что будем делать с сетью
* */
interface PostRepository{
    fun getAllPosts(): Flow<List<Post>>
}