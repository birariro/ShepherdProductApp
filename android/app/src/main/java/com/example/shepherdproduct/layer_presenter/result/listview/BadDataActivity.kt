package com.example.shepherdproduct.layer_presenter.result.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shepherdproduct.R
import com.example.shepherdproduct.databinding.ActivityBadDataBinding
import com.example.shepherdproduct.layer_domain.data.SearchData

class BadDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityBadDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBadDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intentData = intent.getSerializableExtra("searchData")
        if(intentData != null ){
            val searchData = intentData as SearchData
            initUI(searchData)
        }

    }
    private fun initUI(searchData: SearchData){

        val viewManager = LinearLayoutManager(this)
        val viewAdapter = CardViewAdapter()
        viewAdapter.setData(searchData)

        val recyclerView = binding.homeRecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = viewManager
        recyclerView.adapter = viewAdapter

    }
}