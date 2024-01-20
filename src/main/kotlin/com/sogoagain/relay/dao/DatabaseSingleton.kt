package com.sogoagain.relay.dao

import com.sogoagain.relay.models.Events
import com.sogoagain.relay.models.Tags
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseSingleton {
    fun init(config: DatabaseConfig) {
        val database = Database.connect(
            url = config.url,
            driver = "org.postgresql.Driver",
            user = config.user,
            password = config.password
        )
        transaction(database) {
            SchemaUtils.create(Events)
            SchemaUtils.create(Tags)
        }
    }


    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
