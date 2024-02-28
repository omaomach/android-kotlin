package com.example.contactsmanagerapp.room

class UserRepository(private val dao: UserDAO) {
// This class provides a clean api for later access to the rest of the application. It manages queries and allows you to use multiple backends
// It implements the logic for deciding whether to fetch data from a network or use results cached in a local database

    val users = dao.getAllUsers()

    suspend fun insert(user: User): Long {
        return dao.insertUser(user)
    }

    suspend fun delete(user: User) {
        return dao.deleteUser(user)
    }

    suspend fun update(user: User) {
        return dao.updateUser(user)
    }

    suspend fun deleteAll() {
        return dao.deleteAll()
    }

}