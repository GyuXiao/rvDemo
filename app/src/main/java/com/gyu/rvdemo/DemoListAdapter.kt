package com.gyu.rvdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gyu.rvdemo.databinding.ActivityMainBinding
import com.gyu.rvdemo.databinding.RvItemBinding
import javax.sql.DataSource
import kotlin.math.log


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
        Log.d("Gyu", "${currentList.size}")
        holder.run {
            val entity = getItem(position)
            when(entity.backgroundStyle) {
                1 -> binding.rvItem.setBackgroundResource(R.drawable.bg_first_item)
                2 -> binding.rvItem.setBackgroundResource(R.drawable.bg_last_item)
                3 -> binding.rvItem.setBackgroundResource(R.color.item_bg_color)
                4 -> binding.rvItem.setBackgroundResource(R.drawable.bg_item)
            }
        }
    }

    class DemoViewHolder(val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return currentList.size
    }
}





