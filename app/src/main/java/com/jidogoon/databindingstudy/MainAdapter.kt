package com.jidogoon.databindingstudy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jidogoon.databindingstudy.databinding.ListItemPdfBinding
import com.jidogoon.databindingstudy.model.PDFItem
import com.jidogoon.databindingstudy.viewmodel.MainViewModel

class MainAdapter(private val viewModel: MainViewModel): RecyclerView.Adapter<MainAdapter.MainItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val binding = ListItemPdfBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.viewModel = viewModel
        return MainItemViewHolder(binding)
    }

    override fun getItemCount(): Int = viewModel.pdfList.value?.size ?: 0

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        viewModel.pdfList.value?.get(position)?.let { holder.bind(it) }
    }

    class MainItemViewHolder(private val binding: ListItemPdfBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pdfItem: PDFItem) {
            with(binding) {
                pdfData = pdfItem
                executePendingBindings()
            }
        }
    }
}