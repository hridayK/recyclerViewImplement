package com.example.rececylerviewimplment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf(
            Todo("Task",false),
            Todo("Task",false),
            Todo("Task",false),
            Todo("Task",false),
            Todo("Task",false),
        )

        val adapter = TodoAdapter(todoList)
        val btn = findViewById<Button>(R.id.buttonAddTodo)
        val input = findViewById<TextView>(R.id.textViewTodo)
        val rv = findViewById<RecyclerView>(R.id.recyclerViewTodo)

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        btn.setOnClickListener {
            if (!input.text.toString().isBlank()){
                todoList.add(Todo(input.text.toString(), false))
                adapter.notifyDataSetChanged()
                input.text = ""
            }
        }

    }
}