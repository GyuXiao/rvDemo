package com.gyu.rvdemo

import androidx.recyclerview.widget.DiffUtil

/**
 * @author: zk.xiao
 * @email: {zk.xiao@aftership.com}
 * @date: 2022/4/6
 */
open class DemoDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        // 不懂，为什么写死返回 false ，就达到预期了
        return false
    }
}