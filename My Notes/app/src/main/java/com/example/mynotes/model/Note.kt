package com.example.mynotes.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize  // this annotation wil tell android, android studio and kotlin compiler to generate a writeToParcel() and describeContents() as well as create a factory class automatically
data class Note(
    @PrimaryKey
    val id : Int,
    val noteTitle : String,
    val noteBody : String

    // parcelable is an interface that a class can implement to be passed within an intent from an activity to another one

):Parcelable
