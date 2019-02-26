package com.github.madz0

import org.junit.Before
import org.koin.core.KoinProperties
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.test.AutoCloseKoinTest

open class KoinBaseTest: AutoCloseKoinTest() {
    @Before fun before() {
        startKoin(listOf(myModules)).loadProperties(KoinProperties(useKoinPropertiesFile = true))
        App.init
    }
}