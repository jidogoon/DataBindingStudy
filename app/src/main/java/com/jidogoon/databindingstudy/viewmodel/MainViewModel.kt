package com.jidogoon.databindingstudy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jidogoon.databindingstudy.interfaces.IPDFListRepository
import com.jidogoon.databindingstudy.model.PDFItem

class MainViewModel(pdfRepository: IPDFListRepository): ViewModel() {
    private val _pdfList = MutableLiveData<MutableList<PDFItem>>()
    private val _urlAction = ActionLiveData<String>()
    val pdfList: LiveData<MutableList<PDFItem>> get() = _pdfList
    val urlAction: ActionLiveData<String> get() = _urlAction

    init {
        pdfRepository.getPDFList { _pdfList.postValue(it) }
    }

    fun onClickPdfItem(pdfItem: PDFItem) {
        println("clicked! ${pdfItem.name} ${pdfItem.url}")
        _urlAction.sendAction(pdfItem.url)
    }
}