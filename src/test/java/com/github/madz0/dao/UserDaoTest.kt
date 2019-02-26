package com.github.madz0.dao

import com.github.madz0.KoinBaseTest
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Test
import kotlin.test.assertEquals

class UserDaoTest : KoinBaseTest() {
    @Test
    transaction
    {
        val user = UserDao.new {
            email = "madz@test.com"
            userName = "madz"
            name = "madz"
            password = "123"
        }
        assertEquals("madz", user.name)
    }
}

@After
fun after() {
    UserDao.deleteAll()
}
}