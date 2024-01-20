package com.sogoagain.relay

import com.sogoagain.relay.dao.DatabaseConfig
import com.sogoagain.relay.dao.DatabaseSingleton
import com.sogoagain.relay.plugins.configureRouting
import com.sogoagain.relay.plugins.configureSockets
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, environment = commandLineEnvironment(args))
        .start(wait = true)
}

fun Application.module() {
    DatabaseSingleton.init(
        config = DatabaseConfig(
            url = environment.config.property("database.url").getString(),
            user = environment.config.property("database.user").getString(),
            password = environment.config.property("database.password").getString(),
        )
    )
    configureRouting()
    configureSockets()
}
