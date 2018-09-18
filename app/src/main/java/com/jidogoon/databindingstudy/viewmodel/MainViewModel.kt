package com.jidogoon.databindingstudy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jidogoon.databindingstudy.interfaces.IPDFListRepository
import com.jidogoon.databindingstudy.model.PDFItem

class MainViewModel(pdfRepository: IPDFListRepository,
                    private val onClickItemAction: (url: String) -> Unit): ViewModel() {

    companion object {
        const val backgroundColorHex = "#999999"
    }

    private val _pdfList = MutableLiveData<MutableList<PDFItem>>()
    val pdfList: LiveData<MutableList<PDFItem>> get() = _pdfList

    init {
        pdfRepository.getPDFList { _pdfList.postValue(it) }
    }

    fun onClickPdfItem(pdfItem: PDFItem) {
        println("clicked! ${pdfItem.name} ${pdfItem.url}")
        onClickItemAction(pdfItem.url)
    }
}