package com.example.kotlinkoinmvvm.network

import com.example.kotlinkoinmvvm.UI.MainViewModel
import com.example.kotlinkoinmvvm.utils.networkUtils.createWebService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

const val cat_api = "https://api.thecatapi.com/v1/"

val appModules = module {

    single { createWebService() }
    single { CatRepo(catApi = get()) }
    viewModel { MainViewModel( get()) }

}
