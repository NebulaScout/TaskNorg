package com.project.tasknorg.models

data class Task(
    val id: Long? = null,
    var title: String,
    var description: String,
    var completed: Boolean = false
)