package com.talisol.abjadtrainer.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="entry_table")
data class Entry(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val word: String,
    val wordCategory: String,
    val wordGroupNbr: Int,
    val nCorrect: Int,
    val nTotal: Int,
    val lastCorrect: Boolean
): Parcelable