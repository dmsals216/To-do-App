package com.project.eunmin.todoapp.ui.detail.di

import android.content.Context
import com.project.eunmin.todoapp.ui.detail.DetailViewModel
import com.project.eunmin.todoapp.ui.detail.usecase.DetailMoveUsecaseImpl
import com.project.eunmin.todoapp.ui.detail.usecase.DetailToastUsecaeImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val koinForDetailModules = module {
    factory { DetailToastUsecaeImpl(androidContext(), get()) }
    factory { (context: Context) -> DetailMoveUsecaseImpl(context) }
    viewModel { (context: Context) -> DetailViewModel(get(), get(), get(), get{ parametersOf(context) }) }
}