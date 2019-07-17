package com.project.eunmin.todoapp.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoDataModel(@PrimaryKey(autoGenerate = true) var id: Long?, var title: String, var content: String)