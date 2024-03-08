package com.example.mynotes.repository

import com.example.mynotes.database.NoteDAO
import com.example.mynotes.database.NoteDatabase
import com.example.mynotes.model.Note

class NoteRepository(private val db: NoteDatabase) {
// This class provides a clean api for later access to the rest of the application. It manages queries and allows you to use multiple backends
// It implements the logic for deciding whether to fetch data from a network or use results cached in a local database

    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    suspend fun deleteAll() = db.getNoteDao().deleteAll()

    fun getAllNotes() = db.getNoteDao().getAllNotes()

    fun searchNote(query: String) = db.getNoteDao().searchNote(query)

}