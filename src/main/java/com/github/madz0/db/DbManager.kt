package com.github.madz0.db

import org.jetbrains.exposed.sql.Database

interface DbManager {
    fun getDb(): Database
    fun close()
    fun postConstruct()
}