package com.project.eunmin.todoapp.ui.main

import android.content.Intent
import android.util.Log
import androidx.databinding.ObservableArrayList
import com.project.eunmin.todoapp.R
import com.project.eunmin.todoapp.base.RxViewModel
import com.project.eunmin.todoapp.entity.TodoEntity
import com.project.eunmin.todoapp.ui.main.usecase.MainMoveUsecase
import com.project.eunmin.todoapp.ui.main.usecase.MainToastUsecase
import com.project.eunmin.todoapp.usecase.TodoGetUsecase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(todoGetUsecase: TodoGetUsecase, toastUsecase: MainToastUsecase,
                    private val moveUsecase: MainMoveUsecase): RxViewModel() {
    override val layoutId: Int = R.layout.activity_main

    val todoList = ObservableArrayList<TodoEntity>()

    init {
        todoGetUsecase.get().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                todoList.clear()
                todoList.addAll(it)
            }, {
                toastUsecase.getDataErrorMessage()
            }).bindUtilDestroy()
    }

    fun onAddBtnClicked() {
        moveUsecase.moveToAddActivity()
    }
}