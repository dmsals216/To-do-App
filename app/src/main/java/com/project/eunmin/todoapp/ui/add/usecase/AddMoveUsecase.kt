package com.project.eunmin.todoapp.ui.add.usecase

import android.app.Activity
import android.content.Context
import android.content.Intent

interface AddMoveUsecase {
    fun finish()
    fun addFinish(title: String, content: String)
}

class AddMoveUsecaseImpl(private val context: Context): AddMoveUsecase {
    private val activity = context as Activity

    override fun finish() {
        activity.finish()
    }

    override fun addFinish(title: String, content: String) {
        val intent = Intent()
        intent.putExtra("title", title)
        intent.putExtra("content", content)
        activity.setResult(Activity.RESULT_OK, intent)
        activity.finish()
    }

}