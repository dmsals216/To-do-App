package com.project.eunmin.todoapp.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.eunmin.todoapp.entity.TodoEntity
import com.project.eunmin.todoapp.ui.main.adapter.TodoListAdapter

@BindingAdapter("todo_adapter")
fun setTodoListAdapter(recyclerView: RecyclerView, list: ArrayList<TodoEntity>) {
    with(recyclerView) {
        val adapter = adapter as? TodoListAdapter ?: TodoListAdapter().apply {
            adapter = this
            layoutManager = LinearLayoutManager(recyclerView.context)
        }
        adapter.setTodos(list)
    }
}