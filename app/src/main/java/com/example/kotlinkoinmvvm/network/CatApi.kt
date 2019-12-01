package com.example.kotlinkoinmvvm.network

import com.example.kotlinkoinmvvm.Model.Cat
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("images/search")
    fun getCats(@Query ("limit")limit :Int ): Observable<List<Cat>>
}