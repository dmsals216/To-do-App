package com.project.eunmin.todoapp.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {
    abstract val layoutId: Int
}

abstract class RxViewModel : BaseViewModel() {

    private val disposables = CompositeDisposable()

    fun Disposable.bindUtilDestroy() {
        if (!disposables.isDisposed) {
            disposables.add(this)
        } else {
            if (!isDisposed) {
                dispose()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}