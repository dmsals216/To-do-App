package com.project.eunmin.todoapp.usecase

import com.project.eunmin.todoapp.entitygateway.TodoEntityGateway
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface TodoInsertUsecase {
    fun insert(title: String, content: String): Disposable
}

class TodoInsertUsecaseImpl(private val gateway: TodoEntityGateway): TodoInsertUsecase {
    override fun insert(title: String, content: String): Disposable = Completable.fromCallable { gateway.insert(title, content) }.subscribeOn(Schedulers.io()).subscribe()
}