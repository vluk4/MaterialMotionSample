package com.example.materialmotionsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.materialmotionsample.databinding.RecyclerviewItemBinding

class SampleListAdapter(
    private val listener: OnSampleClickListener
) : ListAdapter<Sample, SampleListAdapter.SampleViewHolder>(PlayerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SampleViewHolder(RecyclerviewItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class SampleViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sample: Sample) {
            binding.sample = sample
            binding.listener = listener
            binding.executePendingBindings()
        }
    }

    companion object PlayerDiffCallback : DiffUtil.ItemCallback<Sample>() {
        override fun areItemsTheSame(oldItem: Sample, newItem: Sample): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sample, newItem: Sample): Boolean {
            return oldItem == newItem
        }
    }
}

interface OnSampleClickListener {
    fun onCardSelected(cardView: View)
}
