package ru.yandexpraktikum.notekeeper

import android.app.Application
import ru.yandexpraktikum.notekeeper.di.DaggerApplicationComponent

class NoteKeeperApp : Application() {
    val appComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}