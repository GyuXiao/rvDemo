package com.gyu.rvdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gyu.rvdemo.databinding.RvItemBinding


/**
 * @author: zk.xiao
 * @email: {zk.xiao@aftership.com}
 * @date: 2022/4/6
 */
class DemoListAdapter: ListAdapter<Item, RecyclerView.ViewHolder>(DemoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DemoViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DemoViewHolder) {
            holder.run {
                binding.rvItem.text = getItem(position).content
                setBackgroundRadius(holder, position)
            }
        }
    }

    private fun setBackgroundRadius(holder: DemoViewHolder, position: Int) {
        holder.run {
            if (currentList.size == 1) {
                binding.rvItem.setBackgroundResource(R.drawable.bg_item)
            } else if (currentList.size > 1) {
                currentList.forEachIndexed { _, _ ->
                    when (position) {
                        0 -> binding.rvItem.setBackgroundResource(R.drawable.bg_first_item)
                        currentList.size - 1 -> binding.rvItem.setBackgroundResource(R.drawable.bg_last_item)
                        else -> binding.rvItem.setBackgroundResource(R.color.item_bg_color)
                    }
                }
            }
        }
    }

    class DemoViewHolder(val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return currentList.size
    }
}





