package com.project.eunmin.todoapp.ui.add.di

import android.content.Context
import com.project.eunmin.todoapp.ui.add.AddViewModel
import com.project.eunmin.todoapp.ui.add.usecase.AddMoveUsecase
import com.project.eunmin.todoapp.ui.add.usecase.AddMoveUsecaseImpl
import com.project.eunmin.todoapp.ui.add.usecase.AddToastUsecase
import com.project.eunmin.todoapp.ui.add.usecase.AddToastUsecaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val koinForAddModules = module {
    factory { AddToastUsecaseImpl(androidContext(), get()) as AddToastUsecase }
    factory { (context: Context) -> AddMoveUsecaseImpl(context) as AddMoveUsecase }
    viewModel { (context: Context) -> AddViewModel(get(), get(), get{ parametersOf(context)}) }
}