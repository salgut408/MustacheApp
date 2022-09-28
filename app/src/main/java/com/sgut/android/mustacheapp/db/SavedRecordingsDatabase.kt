package com.sgut.android.mustacheapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sgut.android.mustacheapp.domain.RecordingItem

@Database(
    entities = [RecordingItem::class],
    version = 1,
    exportSchema = false
)

abstract class SavedRecordingsDatabase: RoomDatabase() {
    abstract fun getSavedRecordingsDao(): SavedRecordingsDao

    companion object{
        @Volatile
        private var instance: SavedRecordingsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(SavedRecordingsDatabase.LOCK) {
            SavedRecordingsDatabase.instance ?: SavedRecordingsDatabase.createDatabase(context)
                .also { SavedRecordingsDatabase.instance = it }

        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                SavedRecordingsDatabase::class.java,
                "recordingsDatabase.db"
            ).build()
    }
}