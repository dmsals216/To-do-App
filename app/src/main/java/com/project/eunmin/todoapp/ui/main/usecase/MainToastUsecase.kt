package com.project.eunmin.todoapp.ui.main.usecase

import android.content.Context
import com.project.eunmin.todoapp.R
import com.project.eunmin.todoapp.util.ResourcesProvider
import com.project.eunmin.todoapp.util.toast

interface MainToastUsecase {
    fun getDataErrorMessage()
}

class MainToastUsecaseImpl(private val context: Context, private val resourcesProvider: ResourcesProvider): MainToastUsecase {
    override fun getDataErrorMessage() {
        context.toast(resourcesProvider.string(R.string.get_data_error_message))
    }
}