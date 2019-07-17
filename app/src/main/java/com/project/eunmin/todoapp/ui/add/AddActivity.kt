package com.project.eunmin.todoapp.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.eunmin.todoapp.R
import com.project.eunmin.todoapp.databinding.ActivityAddBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AddActivity : AppCompatActivity() {
    private val viewModel: AddViewModel by viewModel { parametersOf(this) }
    private lateinit var binding: ActivityAddBinding

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