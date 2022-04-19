package com.gyu.rvdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gyu.rvdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val dataSource = getDataList()

    private lateinit var demoListAdapter: DemoListAdapter

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        demoListAdapter = DemoListAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        demoListAdapter.submitList(dataSource)
        recyclerView.adapter = demoListAdapter


        findViewById<Button>(R.id.btn_delete_first).setOnClickListener {
            demoListAdapter.run {
                val filterList = currentList.map { it.copy() }.toMutableList()

                submitList(filterList.filter { it.id != "1" })
                // 这里不应该调用 notifyDataSetChanged 来刷新整个列表样式，但我又找不到更好的方法
//                binding.root.post(this::notifyDataSetChanged)
            }

            Toast.makeText(this, "删了第 1 项", Toast.LENGTH_SHORT).show()
        }
    }


    private fun getDataList(): ArrayList<Item> {
        return arrayListOf<Item>(
            Item("1", "item1"),
            Item("2", "item2"),
            Item("3", "item3"),
            Item("4", "item4"),
            Item("5", "item5")
        )
    }
}