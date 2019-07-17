package com.project.eunmin.todoapp.ui.detail.usecase

import android.app.Activity
import android.content.Context

interface DetailMoveUsecase {
    fun finish()
}

class DetailMoveUsecaseImpl(private val context: Context): DetailMoveUsecase {
    private val activity = context as Activity

    override fun finish() {
        activity.finish()
    }
}