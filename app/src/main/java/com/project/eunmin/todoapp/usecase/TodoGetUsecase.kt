package com.project.eunmin.todoapp.usecase

import com.project.eunmin.todoapp.entity.TodoEntity
import com.project.eunmin.todoapp.entitygateway.TodoEntityGateway
import io.reactivex.Flowable

interface TodoGetUsecase {
    fun get(): Flowable<List<TodoEntity>>
    fun get(id: Long): Flowable<TodoEntity>
}

class TodoGetUsecaseImpl(private val gateway: TodoEntityGateway): TodoGetUsecase {
    override fun get(): Flowable<List<TodoEntity>> = gateway.get()

    override fun get(id: Long): Flowable<TodoEntity> = gateway.get(id)

}