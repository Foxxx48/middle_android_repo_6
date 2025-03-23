package ru.yandexpraktikum.core.presentation.model

import javax.inject.Inject

data class NoteUi @Inject constructor(
    val id: Int = 0,
    val title: String,
    val content: String
)