package com.example.admin.kotlinvideorecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.admin.kotlinvideorecyclerview.adapter.CustomAdapter
import com.example.admin.kotlinvideorecyclerview.viewmodel.CategoryViewModel


class MainActivity : AppCompatActivity() {

    private var recycleview: RecyclerView? = null
    private var customadapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleview = findViewById(R.id.recyclerview)
        val categoryViewModel: CategoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        categoryViewModel.getArrayList().observe(this, Observer { categoryViewModels ->
            customadapter = CustomAdapter(this@MainActivity, categoryViewModels!!)
            recycleview!!.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
            recycleview!!.adapter = customadapter
        })


    }
}
