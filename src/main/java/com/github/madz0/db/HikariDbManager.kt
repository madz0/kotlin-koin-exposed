package com.github.madz0.db

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.koin.standalone.KoinComponent
import org.koin.standalone.property

class HikariDbManager : DbManager, KoinComponent {
    override fun getDb(): Database {
        return Database.connect(dataSource)
    }

    val dataSource = HikariDataSource()
    val dataSourceUrl: String by property("datasource.jdbc-url")
    val maxPoolSize: Int by property("datasource.max-pool-size")
    override fun close() {
        dataSource.close()
    }

    override fun postConstruct() {
        dataSource.jdbcUrl = dataSourceUrl
        dataSource.maximumPoolSize = maxPoolSize
        getDb()
    }
}