package com.sgut.android.mustacheapp.di

import android.content.Context
import androidx.room.Room
import com.sgut.android.mustacheapp.db.SavedRecordingsDao
import com.sgut.android.mustacheapp.db.SavedRecordingsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideSavedRecordingsDao(savedRecordingsDatabase: SavedRecordingsDatabase): SavedRecordingsDao = savedRecordingsDatabase.getSavedRecordingsDao()

    @Provides
    @Singleton
    fun provideSavedRecordingsDatabase(@ApplicationContext context: Context): SavedRecordingsDatabase =
        Room.databaseBuilder(
            context,
            SavedRecordingsDatabase::class.java,
            "savedRecordingsDatabase"
        ).build()
}