package com.jidogoon.databindingstudy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jidogoon.databindingstudy.interfaces.IPDFListRepository

class ViewModelFactory(): ViewModelProvider.Factory {
    private lateinit var pdfRepository: IPDFListRepository
    private lateinit var onClickItemAction: (url: String) -> Unit
    constructor(repository: IPDFListRepository, onClickItemAction: (url: String) -> Unit): this() {
        this.pdfRepository = repository
        this.onClickItemAction = onClickItemAction
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(pdfRepository, onClickItemAction) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}