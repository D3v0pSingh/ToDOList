package com.example.todolistrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), customAdapter.onItemCLickListener {
private  lateinit var con:MutableList<Data>
private lateinit var adapter:customAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         con = mutableListOf(
            Data("Hello my name is gagandeep singh")
        )

        adapter = customAdapter(con,this)
        recycle.adapter = adapter
        recycle.layoutManager = LinearLayoutManager(this)

        plus.setOnClickListener {
            val ed = editext.text.toString()
            con.add(Data(ed))
        }
    }

    override fun onItemClick(position: Int) {
       val currentSize = con.size
        con.removeAt(position)
        adapter.notifyItemChanged(position)
        adapter.notifyItemRangeRemoved(0,currentSize)
        Toast.makeText(this,"Item was deleted",Toast.LENGTH_SHORT).show()
    }
}