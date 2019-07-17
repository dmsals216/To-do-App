package com.project.eunmin.todoapp.di

import com.project.eunmin.todoapp.database.AppDatabase
import com.project.eunmin.todoapp.entitygateway.TodoEntityGateway
import com.project.eunmin.todoapp.entitygateway.TodoEntityGatewayImpl
import com.project.eunmin.todoapp.usecase.*
import com.project.eunmin.todoapp.util.ResourcesProvider
import com.project.eunmin.todoapp.util.ResourcesProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val koinModules = module {
    single { AppDatabase.getInstance(androidContext()).todoDao() }
    factory { TodoEntityGatewayImpl(get()) as TodoEntityGateway }

    factory { TodoGetUsecaseImpl(get()) as TodoGetUsecase }
    factory { TodoInsertUsecaseImpl(get()) as TodoInsertUsecase }
    factory { TodoUpdateUsecaseImpl(get()) as TodoUpdateUsecase }
    factory { TodoDeleteUsecaseImpl(get()) as TodoDeleteUsecase }
    factory { ResourcesProviderImpl(androidContext()) as ResourcesProvider }
}