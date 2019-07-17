package com.project.eunmin.todoapp.ui.detail.usecase

import android.content.Context
import com.project.eunmin.todoapp.R
import com.project.eunmin.todoapp.util.ResourcesProvider
import com.project.eunmin.todoapp.util.toast

interface DetailToastUsecase {
    fun update()
    fun delete()
}

class DetailToastUsecaeImpl(private val context: Context, private val resourcesProvider: ResourcesProvider): DetailToastUsecase {
    override fun update() {
        context.toast(resourcesProvider.string(R.string.update_item))
    }

    override fun delete() {
        context.toast(resourcesProvider.string(R.string.delete_item))
    }

}