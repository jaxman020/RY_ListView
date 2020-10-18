package com.example.ry_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    private var from = arrayOf("title")
    private var to = intArrayOf(R.id.itemTitle)
    private var data = LinkedList<HashMap<String, String>>()
    private lateinit var adapter : SimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListView()
    }

    private fun initListView(){


        var d0 = HashMap<String, String>()
        d0.put(from[0], "Test1")
        data.add(d0)
        var d1 = HashMap<String, String>()
        d1.put(from[0], "Test2")
        data.add(d1)
        var d2 = HashMap<String, String>()
        d2.put(from[0], "Test3")
        data.add(d2)

        adapter = SimpleAdapter(this, data, R.layout.item, from, to)

        list.adapter = adapter
    }

    fun addItem(view: View) {
        var d2 = HashMap<String, String>()
        d2.put(from[0], "Test4")
        data.add(d2)

        adapter.notifyDataSetChanged()
    }
    fun deleteItem(view: View) {
        if(data.size > 0) data.removeAt(0)

        adapter.notifyDataSetChanged()
    }
}