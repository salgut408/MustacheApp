package com.sgut.android.mustacheapp.domain

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recordings_database")
data class RecordingItem(
    var tag: String? = null,
    var videoDuration: Int? = null,
    var path: String? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null


)
