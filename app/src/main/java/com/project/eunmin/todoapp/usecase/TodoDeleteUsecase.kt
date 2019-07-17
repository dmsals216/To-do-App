package com.project.eunmin.todoapp.usecase

import com.project.eunmin.todoapp.entity.TodoEntity
import com.project.eunmin.todoapp.entitygateway.TodoEntityGateway
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface TodoDeleteUsecase {
    fun delete(todo: TodoEntity): Disposable
}

class TodoDeleteUsecaseImpl(private val gateway: TodoEntityGateway): TodoDeleteUsecase {
    override fun delete(todo: TodoEntity): Disposable = Completable.fromCallable { gateway.delete(todo) }.subscribeOn(Schedulers.io()).subscribe()
}
