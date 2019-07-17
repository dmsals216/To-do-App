package com.project.eunmin.todoapp.ui.detail

import androidx.databinding.ObservableField
import com.project.eunmin.todoapp.R
import com.project.eunmin.todoapp.base.RxViewModel
import com.project.eunmin.todoapp.entity.TodoEntity
import com.project.eunmin.todoapp.ui.detail.usecase.DetailMoveUsecase
import com.project.eunmin.todoapp.ui.detail.usecase.DetailToastUsecase
import com.project.eunmin.todoapp.usecase.TodoDeleteUsecase
import com.project.eunmin.todoapp.usecase.TodoUpdateUsecase

class DetailViewModel(private val todoUpdateUsecase: TodoUpdateUsecase,
                      private val todoDeleteUsecase: TodoDeleteUsecase,
                      private val detailToastUsecase: DetailToastUsecase,
                      private val detailMoveUsecase: DetailMoveUsecase): RxViewModel() {
    override val layoutId: Int = R.layout.activity_detail

    val todo = ObservableField<TodoEntity>()

    fun onUpdateBtnClicked() {
        todoUpdateUsecase.update(todo.get()!!).bindUtilDestroy()
        detailToastUsecase.update()
        detailMoveUsecase.finish()
    }

    fun onDeleteBtnClicked() {
        todoDeleteUsecase.delete(todo.get()!!).bindUtilDestroy()
        detailToastUsecase.delete()
        detailMoveUsecase.finish()
    }
}