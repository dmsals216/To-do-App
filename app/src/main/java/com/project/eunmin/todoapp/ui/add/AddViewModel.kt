package com.project.eunmin.todoapp.ui.add

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.project.eunmin.todoapp.R
import com.project.eunmin.todoapp.base.RxViewModel
import com.project.eunmin.todoapp.ui.add.usecase.AddMoveUsecase
import com.project.eunmin.todoapp.ui.add.usecase.AddToastUsecase
import com.project.eunmin.todoapp.usecase.TodoInsertUsecase

class AddViewModel(private val todoInsertUsecase: TodoInsertUsecase,
                   private val addToastUsecase: AddToastUsecase,
                   private val addMoveUsecase: AddMoveUsecase): RxViewModel() {
    override val layoutId: Int = R.layout.activity_add

    val title = ObservableField("")
    val content = ObservableField("")

    val addBtnEnabled = ObservableBoolean(false)

    fun onTitleTextChanged() {
        addBtnEnabled.set(title.get()!!.isNotEmpty() && content.get()!!.isNotEmpty())
    }

    fun onContentTextChanged() {
        addBtnEnabled.set(title.get()!!.isNotEmpty() && content.get()!!.isNotEmpty())
    }

    fun onAddBtnClicked() {
        todoInsertUsecase.insert(title.get()!!, content.get()!!).bindUtilDestroy()
        addToastUsecase.add()
        addMoveUsecase.addFinish(title.get()!!, content.get()!!)
    }

    fun onCancelBtnClicked() {
        addMoveUsecase.finish()
    }
}