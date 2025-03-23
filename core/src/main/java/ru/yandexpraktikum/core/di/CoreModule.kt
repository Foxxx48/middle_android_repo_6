package ru.yandexpraktikum.core.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.yandexpraktikum.core.data.db.NoteDao
import ru.yandexpraktikum.core.data.db.NoteDatabase
import ru.yandexpraktikum.core.data.repository.NotesRepositoryImpl
import ru.yandexpraktikum.core.domain.repository.NotesRepository
import javax.inject.Singleton

@Module
interface CoreModule {

    @Binds
    @Singleton
    fun bindsNotesRepository(repository: NotesRepositoryImpl): NotesRepository

    companion object {
        private const val DATABASE_NAME = "note_database"

        @Provides
        @Singleton
//        fun providesNoteDatabase(context: Context): NoteDatabase {
        fun providesNoteDatabase(application: Application): NoteDatabase {
            return Room.databaseBuilder(
//                context.applicationContext,
                application,
                NoteDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

        @Provides
        @Singleton
        fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao {
            return noteDatabase.noteDao()
        }
    }
}