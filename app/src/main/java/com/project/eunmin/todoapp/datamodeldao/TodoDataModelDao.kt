package com.project.eunmin.todoapp.datamodeldao

import androidx.room.*
import com.project.eunmin.todoapp.datamodel.TodoDataModel
import io.reactivex.Flowable

@Dao
interface TodoDataModelDao {

    @Query("SELECT * FROM TODO")
    fun get(): Flowable<List<TodoDataModel>>

    @Query("SELECT * FROM TODO WHERE id = :id")
    fun get(id: Long): Flowable<TodoDataModel>

    @Insert
    fun insert(todo: TodoDataModel)

    @Update
    fun update(todo: TodoDataModel)

    @Delete
    fun delete(todo: TodoDataModel)
}