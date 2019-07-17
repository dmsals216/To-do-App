package com.project.eunmin.todoapp.util

import android.content.Context
import androidx.annotation.StringRes

interface ResourcesProvider {
    fun string(@StringRes id: Int): String
    fun string(@StringRes id: Int, vararg args: String): String
}

class ResourcesProviderImpl(context: Context) : ResourcesProvider {
    private val resources = context.resources
    override fun string(@StringRes id: Int) = resources.getString(id)
    override fun string(@StringRes id: Int, vararg args: String) = resources.getString(id, args)
}