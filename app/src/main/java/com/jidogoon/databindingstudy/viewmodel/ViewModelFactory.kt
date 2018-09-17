package com.jidogoon.databindingstudy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jidogoon.databindingstudy.interfaces.IPDFListRepository

class ViewModelFactory(): ViewModelProvider.Factory {
    private lateinit var pdfRepository: IPDFListRepository
    constructor(repository: IPDFListRepository): this() {
        this.pdfRepository = repository
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(pdfRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}