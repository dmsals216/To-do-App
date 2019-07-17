package com.project.eunmin.todoapp.ui.main.usecase

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.project.eunmin.todoapp.ui.add.AddActivity
import com.project.eunmin.todoapp.ui.detail.DetailActivity

interface MainMoveUsecase {
    fun moveToAddActivity()
    fun moveToDetailActivity()
}

class MainMoveUsecaseImpl(context: Context): MainMoveUsecase {
    private val activity = context as Activity

    override fun moveToAddActivity() {
        val intent = Intent(activity, AddActivity::class.java)
        activity.startActivity(intent)
    }

    override fun moveToDetailActivity() {
        val intent = Intent(activity, DetailActivity::class.java)
        activity.startActivity(intent)
    }
}