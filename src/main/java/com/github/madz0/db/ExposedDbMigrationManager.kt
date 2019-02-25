package com.github.madz0.db

import com.github.madz0.dao.UserTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class ExposedDbMigrationManager : DbMigrationManager {
    override fun handleMigration() {
        transaction {
            SchemaUtils.createMissingTablesAndColumns(UserTable)
        }
    }
}