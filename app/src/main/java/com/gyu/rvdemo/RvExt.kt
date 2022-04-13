package com.gyu.rvdemo

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: zk.xiao
 * @email: {zk.xiao@aftership.com}
 * @date: 2022/4/13
 */
class RvExt {

    fun <T, VH : RecyclerView.ViewHolder> ListAdapter<T, VH>.updateList(list: List<T>?) {
        // ListAdapter<>.submitList() contains (stripped):
        //  if (newList == mList) {
        //      // nothing to do
        //      return;
        //  }
        this.submitList(if (list == this.currentList) list.toList() else list)
    }
}