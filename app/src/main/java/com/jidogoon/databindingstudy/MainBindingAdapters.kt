package com.jidogoon.databindingstudy

import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jidogoon.databindingstudy.viewmodel.MainViewModel

object MainBindingAdapters {
    @JvmStatic
    @BindingAdapter("jidogoon:backgroundColor")
    fun setItemBackground(layout: ConstraintLayout, colorHex: String) {
        println("setItemBackground")
        layout.setBackgroundColor(Color.parseColor(colorHex))
    }

    @JvmStatic
    @BindingAdapter("jidogoon:bindViewModel")
    fun bindViewModel(recyclerView: RecyclerView, viewModel: MainViewModel) {
        recyclerView.apply {
            adapter = MainAdapter(viewModel)
            adapter?.notifyDataSetChanged()
        }
    }
}