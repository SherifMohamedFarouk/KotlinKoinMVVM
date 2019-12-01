package com.example.kotlinkoinmvvm.UI

import android.os.AsyncTask
import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinkoinmvvm.Model.Cat
import com.example.kotlinkoinmvvm.network.CatRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception
import java.util.logging.Handler

class MainViewModel(private val catRepo: CatRepo):ViewModel()  {
    val catlist = MutableLiveData<List<Cat>>()
    val expmessage = MutableLiveData<String>()
    var disposable: Disposable? = null

    fun LoadCats() {





            disposable = catRepo.getCats(30)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> Log.v("cateed", "" + result)
                        catlist.value = result
                    },
                    { error -> Log.e("ERROR", error.message)
                        expmessage.value = error.toString()
                    }
                )


    }

//    val runnable = Runnable {
//        // we need to execute our network call in the background in order not to block our ui so we will use runnable
//        // and execute it using AsyncTask which will be outside of the runnable
//
//        val getCatList = catRepo.getCats()
//        Log.e("heyy",getCatList.toString())
//        android.os.Handler(Looper.getMainLooper()).post {
//            if (getCatList?.body() != null && getCatList.isSuccessful) {
//                catlist.value = getCatList.body()
//                Log.e("heyy",catlist.toString())
//
//            } else {
//                try {
//                    expmessage.value = getCatList!!.message()
//                } catch (e: Exception) {
//                    expmessage.value = e.message
//
//                }
//            }
//        }
//    }
//    AsyncTask.execute(runnable)
}



