package com.github.madz0.dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.koin.standalone.KoinComponent

class UserDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDao>(UserTable)
    val name by UserTable.name
    val userName by UserTable.userName
    val password by UserTable.password
    val email by UserTable.email
}

object UserTable : IntIdTable("user"), KoinComponent {
    val name: Column<Int> = integer("name")
    val userName: Column<String> = varchar("username", 100)
    val password: Column<String> = varchar("password", 100)
    val email: Column<String> = varchar("email", 100)

    init {
        index(true, email)
        index(true, userName)
    }
}
