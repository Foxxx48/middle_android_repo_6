package ru.yandexpraktikum.core.domain.model

import javax.inject.Inject

data class Note @Inject constructor(
    val id: Int = 0,
    val title: String,
    val content: String,
)