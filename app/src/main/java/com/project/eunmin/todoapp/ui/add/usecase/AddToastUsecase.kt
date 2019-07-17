package com.project.eunmin.todoapp.ui.add.usecase

import android.content.Context
import com.project.eunmin.todoapp.R
import com.project.eunmin.todoapp.util.ResourcesProvider
import com.project.eunmin.todoapp.util.toast

interface AddToastUsecase {
    fun add()
}

class AddToastUsecaseImpl(private val context: Context, private val resourcesProvider: ResourcesProvider): AddToastUsecase {
    override fun add() {
        context.toast(resourcesProvider.string(R.string.add_item))
    }

}