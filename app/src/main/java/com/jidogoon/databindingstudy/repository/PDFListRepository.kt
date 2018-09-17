package com.jidogoon.databindingstudy.repository

import com.jidogoon.databindingstudy.interfaces.IPDFListRepository
import com.jidogoon.databindingstudy.model.PDFItem

class PDFListRepository: IPDFListRepository {
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