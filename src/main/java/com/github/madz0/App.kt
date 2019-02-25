package com.github.madz0

import com.github.madz0.db.DbManager
import com.github.madz0.db.DbMigrationManager
import com.github.madz0.db.HikariDbManager
import com.github.madz0.db.ExposedDbMigrationManager
import com.zaxxer.hikari.HikariDataSource
import org.koin.core.KoinProperties
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import javax.sql.DataSource

object App : KoinComponent {
    val dbManager: DbManager by inject()
    val dbMigrationManager: DbMigrationManager by inject()
    val init: () -> Unit = {
        dbManager.postConstruct()
        dbMigrationManager.handleMigration()
    }
}

fun main(args: Array<String>) {
    startKoin(listOf(myModules)).loadProperties(KoinProperties(useKoinPropertiesFile = true))
    App.init()
}

var myModules = module {
    single { HikariDataSource() as DataSource }
    single<DbManager> { HikariDbManager() }
    single<DbMigrationManager> { ExposedDbMigrationManager() }
}