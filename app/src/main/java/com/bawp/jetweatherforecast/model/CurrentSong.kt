package com.bawp.jetweatherforecast.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "notes_tbl")
data class CurrentSong (
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "song_duration")
    val duration: Int,
    @ColumnInfo(name = "song_name")
    val title: String,
    //val user: String
)


