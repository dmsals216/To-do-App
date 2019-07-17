package com.project.eunmin.todoapp.ui.main.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.eunmin.todoapp.databinding.TodoItemBinding
import com.project.eunmin.todoapp.entity.TodoEntity
import com.project.eunmin.todoapp.ui.detail.DetailActivity
import com.project.eunmin.todoapp.ui.main.MainViewModel
import kotlinx.android.synthetic.main.todo_item.view.*

class TodoListAdapter: RecyclerView.Adapter<TodoListAdapter.TodoListHolder>() {
    var list = arrayListOf<TodoEntity>()

    fun setTodos(list: ArrayList<TodoEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoListHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TodoListHolder, position: Int) {
        holder.bind(list[position])
    }

    class TodoListHolder(private val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.stage.setOnClickListener {
                val intent = Intent(it.context, DetailActivity::class.java)
                intent.putExtra("id", binding.item!!.id)
                (it.context as Activity).startActivity(intent)
            }
        }

        fun bind(item: TodoEntity) {
            binding.item = item
        }
    }
}