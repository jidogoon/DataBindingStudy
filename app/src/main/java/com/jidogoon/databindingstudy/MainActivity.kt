package com.jidogoon.databindingstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.jidogoon.databindingstudy.databinding.ActivityMainBinding
import com.jidogoon.databindingstudy.pdfview.PDFViewActivity
import com.jidogoon.databindingstudy.repository.PDFListRepository
import com.jidogoon.databindingstudy.viewmodel.MainViewModel
import com.jidogoon.databindingstudy.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        val repository = PDFListRepository()
        val onClickItemAction = { url: String -> PDFViewActivity.startActivity(this@MainActivity, url) }
        ViewModelProviders.of(this, ViewModelFactory(repository, onClickItemAction)).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }
}