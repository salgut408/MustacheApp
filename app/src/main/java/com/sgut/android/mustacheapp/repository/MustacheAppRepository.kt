package com.sgut.android.mustacheapp.repository

import android.content.Context
import com.sgut.android.mustacheapp.db.SavedRecordingsDatabase
import com.sgut.android.mustacheapp.domain.RecordingItem
import javax.inject.Inject

class MustacheAppRepository @Inject constructor(
    val recordingsDatabase: SavedRecordingsDatabase,

) {
    suspend fun upsert(recordingItem: RecordingItem) = recordingsDatabase.getSavedRecordingsDao().upsert(recordingItem)

    suspend fun deleteRecordingItem(recordingItem: RecordingItem) = recordingsDatabase.getSavedRecordingsDao().deleteRecordingItem(recordingItem)

    fun getSavedRecordingItems() = recordingsDatabase.getSavedRecordingsDao().getAllRecordingsFromDb()
}