package com.jidogoon.databindingstudy.interfaces

import com.jidogoon.databindingstudy.model.PDFItem

interface IPDFListRepository {
    fun getPDFList(result: (MutableList<PDFItem>) -> Unit)
}