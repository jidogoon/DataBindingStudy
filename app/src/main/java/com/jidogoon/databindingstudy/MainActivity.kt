package com.jidogoon.databindingstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jidogoon.databindingstudy.databinding.ActivityMainBinding
import com.jidogoon.databindingstudy.pdfview.PDFViewActivity
import com.jidogoon.databindingstudy.repository.PDFListRepository
import com.jidogoon.databindingstudy.viewmodel.MainViewModel
import com.jidogoon.databindingstudy.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        val repository = PDFListRepository()
        ViewModelProviders.of(this, ViewModelFactory(repository)).get(MainViewModel::class.java).apply {
            urlAction.observe(this@MainActivity, Observer {
                PDFViewActivity.startActivity(this@MainActivity, it)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = MainAdapter(viewModel)
    }
}