package by.sitko.demo.adapter

import androidx.recyclerview.widget.RecyclerView
import by.sitko.demo.databinding.ItemRecyclerBinding
import by.sitko.demo.model.TextItem

class TextViewHolder(private val binding: ItemRecyclerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TextItem) {
        binding.textView.text = item.text
    }
}