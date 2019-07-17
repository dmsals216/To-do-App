package com.project.eunmin.todoapp.base

import android.app.Application
import com.project.eunmin.todoapp.di.koinModules
import com.project.eunmin.todoapp.ui.add.di.koinForAddModules
import com.project.eunmin.todoapp.ui.detail.di.koinForDetailModules
import com.project.eunmin.todoapp.ui.main.di.koinForMainModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(koinModules, koinForMainModules, koinForAddModules, koinForDetailModules))
        }
    }
}