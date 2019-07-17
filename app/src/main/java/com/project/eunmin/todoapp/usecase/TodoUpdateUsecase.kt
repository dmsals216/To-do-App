package com.project.eunmin.todoapp.usecase

import com.project.eunmin.todoapp.entity.TodoEntity
import com.project.eunmin.todoapp.entitygateway.TodoEntityGateway
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface TodoUpdateUsecase {
    fun update(todo: TodoEntity): Disposable
}

class TodoUpdateUsecaseImpl(private val gateway: TodoEntityGateway): TodoUpdateUsecase {
    override fun update(todo: TodoEntity): Disposable = Completable.fromCallable { gateway.update(todo) }.subscribeOn(Schedulers.io()).subscribe()
}