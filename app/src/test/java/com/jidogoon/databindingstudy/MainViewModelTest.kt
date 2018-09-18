package com.jidogoon.databindingstudy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jidogoon.databindingstudy.interfaces.IPDFListRepository
import com.jidogoon.databindingstudy.model.PDFItem
import com.jidogoon.databindingstudy.viewmodel.MainViewModel
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @Rule
    @JvmField
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel
    private var onItemClicked = false

    @Before
    fun `셋업`() {
        val mockRepository = object: IPDFListRepository {
            override fun getPDFList(result: (MutableList<PDFItem>) -> Unit) {
                val pdfList = mutableListOf<PDFItem>()
                pdfList.apply {
                    add(PDFItem("Fill list entries from pasted text list",
                            "https://www.pdfscripting.com/public/FreeStuff/PDFSamples/PDFS_CopyPastListEntries.pdf"))
                    add(PDFItem("JavaScript Popup Calendar",
                            "https://www.pdfscripting.com/public/FreeStuff/PDFSamples/JSPopupCalendar.pdf"))
                    add(PDFItem("Modifying the LiveCycle Submit Button",
                            "https://www.pdfscripting.com/public/FreeStuff/PDFSamples/ModifySubmit_Example.pdf"))
                    add(PDFItem("Dynamically Modify Email Submit Address",
                            "https://www.pdfscripting.com/public/FreeStuff/PDFSamples/DynamicEmail_AcroForm.pdf"))
                    add(PDFItem("Dynamically Modify Email Submit Address in a LiveCycle(XFA) Form",
                            "https://www.pdfscripting.com/public/FreeStuff/PDFSamples/DynamicEmail_XFAForm_V2.pdf"))
                }
                result(pdfList)
            }
        }
        val onItemClickAction = { url: String ->
            println("clicked = $url")
            onItemClicked = true
        }
        viewModel = MainViewModel(mockRepository, onItemClickAction)
    }

    @Test
    fun `아이템 눌렀을때 화면 이동 테스트`() {
        val pdfItem = viewModel.pdfList.value?.get(0)!!
        assertFalse(onItemClicked)
        viewModel.onClickPdfItem(pdfItem)
        assertTrue(onItemClicked)
    }
}