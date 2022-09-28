package com.sgut.android.mustacheapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sgut.android.mustacheapp.domain.RecordingItem

@Dao
interface SavedRecordingsDao {
    @Query("SELECT * FROM recordings_database")
    fun getAllRecordingsFromDb(): LiveData<List<RecordingItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(recordingItem: RecordingItem): Long

    @Query("DELETE FROM recordings_database")
    fun clear()

    @Delete
    suspend fun deleteRecordingItem(recordingItem: RecordingItem)

}