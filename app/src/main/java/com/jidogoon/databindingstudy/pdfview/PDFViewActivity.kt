package com.jidogoon.databindingstudy.pdfview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jidogoon.databindingstudy.R
import com.jidogoon.pdfrendererview.PdfRendererView

class PDFViewActivity: AppCompatActivity() {
    companion object {
        private const val KEY_URL = "KEY_URL"
        fun startActivity(activity: Activity, url: String) {
            val intent = Intent(activity, PDFViewActivity::class.java)
            intent.putExtra(KEY_URL, url)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfview)
        val url = intent.getStringExtra(KEY_URL)
        findViewById<PdfRendererView>(R.id.pdfView).initWithUrl(url)
    }
}