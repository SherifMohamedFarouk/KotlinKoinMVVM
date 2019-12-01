package com.example.kotlinkoinmvvm.network

import com.example.kotlinkoinmvvm.Model.Cat
import com.example.kotlinkoinmvvm.utils.networkUtils.createWebService
import io.reactivex.Observable
import java.util.*

class CatRepo(private val catApi: CatApi) {


    fun getCats(limit: Int): Observable<List<Cat>> {
        return catApi.getCats(limit)
    }

}