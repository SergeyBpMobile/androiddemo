package by.sitko.demo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import by.sitko.demo.databinding.ItemRecyclerBinding
import by.sitko.demo.model.TextItem

class RecyclerAdapter : ListAdapter<TextItem, TextViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            binding = ItemRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TextItem>() {
            override fun areItemsTheSame(oldItem: TextItem, newItem: TextItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: TextItem, newItem: TextItem): Boolean {
                return oldItem.text == newItem.text
            }
        }
    }
}