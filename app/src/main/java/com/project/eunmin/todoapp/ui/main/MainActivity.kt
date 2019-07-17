package com.project.eunmin.todoapp.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.eunmin.todoapp.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel { parametersOf(this) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
    }

    private fun bind() {
        binding = DataBindingUtil.setContentView(this, viewModel.layoutId)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}
