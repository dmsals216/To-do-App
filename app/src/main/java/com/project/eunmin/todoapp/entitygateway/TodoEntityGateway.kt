package com.project.eunmin.todoapp.entitygateway

import com.project.eunmin.todoapp.datamodel.TodoDataModel
import com.project.eunmin.todoapp.datamodeldao.TodoDataModelDao
import com.project.eunmin.todoapp.entity.TodoEntity
import io.reactivex.Flowable

interface TodoEntityGateway {
    fun get(): Flowable<List<TodoEntity>>
    fun get(id: Long): Flowable<TodoEntity>
    fun insert(title: String, content: String)
    fun update(todo: TodoEntity)
    fun delete(todo:TodoEntity)
}

class TodoEntityGatewayImpl(private val dao: TodoDataModelDao): TodoEntityGateway {

    private fun convert(d: TodoDataModel) = TodoEntity(d.id!!, d.title, d.content)

    override fun get() = dao.get().map { it.map (::convert) }

    override fun get(id: Long) = dao.get(id).map(::convert)

    override fun insert(title: String, content: String) = dao.insert(TodoDataModel(null, title, content))

    override fun update(todo: TodoEntity) = dao.update(TodoDataModel(todo.id, todo.title, todo.content))

    override fun delete(todo: TodoEntity) = dao.delete(TodoDataModel(todo.id, todo.title, todo.content))

}