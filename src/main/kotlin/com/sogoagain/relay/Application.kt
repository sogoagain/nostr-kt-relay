package com.sogoagain.relay

import com.sogoagain.relay.plugins.*
import com.sogoagain.relay.plugins.configureDatabases
import com.sogoagain.relay.plugins.configureMonitoring
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, environment = commandLineEnvironment(args))
        .start(wait = true)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureDatabases()
    configureSockets()
    configureTemplating()
    configureRouting()
}
