package com.example.kotlinkoinmvvm.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinkoinmvvm.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by inject()
    private lateinit var catAdapter :CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startRecucleview()
        getviewModel()
    }

    private fun startRecucleview(){
        // initializing catAdapter with empty list
        catAdapter = CatAdapter(emptyList())
        // apply allows you to alter variables inside the object and assign them
        catsRecyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        catsRecyclerView.adapter = catAdapter
    }
    private fun getviewModel(){
     mainViewModel.expmessage.observe(this, Observer { Expmessageres ->
         Toast.makeText(this , Expmessageres , Toast.LENGTH_SHORT).show()
        mainProgressBar.visibility = View.GONE

     })

      mainViewModel.catlist.observe(this, Observer { getCatList -> catAdapter.updateData(getCatList!!)
          mainProgressBar.visibility = View.GONE
      })
        mainProgressBar.visibility = View.VISIBLE
        mainViewModel.LoadCats()
    }
}
