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
                val filterList = currentList.filter { it.id != "1" }
                val resultList = mutableListOf<Item>()
                filterList?.let { resultList.addAll(it) }
                if (resultList.size == 1) {
                    resultList.forEach { it.backgroundStyle = 4 }
                } else if (resultList.size > 1) {
                    resultList.forEachIndexed { index, item ->
                        when(index) {
                            0 -> item.backgroundStyle = 1
                            resultList.size - 1 -> item.backgroundStyle = 2
                            else -> item.backgroundStyle = 3
                        }
                    }
                }
                submitList(resultList)
                // 这里不应该调用 notifyDataSetChanged，但我又找不到更好的方法
//                binding.root.post(this::notifyDataSetChanged)
            }

            Toast.makeText(this, "删了第 1 个", Toast.LENGTH_SHORT).show()
        }
    }


    private fun getDataList(): ArrayList<Item> {
        return arrayListOf<Item>(
            Item("1", "item1", 1),
            Item("2", "item2", 3),
            Item("3", "item3",3),
            Item("4", "item4",3),
            Item("5", "item5",3),
            Item("6", "item6",3),
            Item("7", "item7",3),
            Item("8", "item8",3),
            Item("9", "item9",3),
            Item("10", "item10",2)
        )
    }
}