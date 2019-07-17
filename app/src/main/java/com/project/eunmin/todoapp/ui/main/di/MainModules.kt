package com.project.eunmin.todoapp.ui.main.di

import android.content.Context
import com.project.eunmin.todoapp.ui.main.MainViewModel
import com.project.eunmin.todoapp.ui.main.usecase.MainMoveUsecase
import com.project.eunmin.todoapp.ui.main.usecase.MainMoveUsecaseImpl
import com.project.eunmin.todoapp.ui.main.usecase.MainToastUsecase
import com.project.eunmin.todoapp.ui.main.usecase.MainToastUsecaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val koinForMainModules = module {
    factory { MainToastUsecaseImpl(androidContext(), get()) as MainToastUsecase }
    factory { (context: Context) -> MainMoveUsecaseImpl(context) as MainMoveUsecase }
    viewModel { (context: Context) -> MainViewModel(get(), get(), get{ parametersOf(context) }) }
}