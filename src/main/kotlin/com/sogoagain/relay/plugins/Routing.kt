package com.sogoagain.relay.plugins

import com.sogoagain.relay.dao.dao
import com.sogoagain.relay.domain.NostrEvent
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            val added = NostrEvent(
                id = "4376c65d2f232afbe9b882a35baa4f6fe8667c4e684749af565f981833ed6a65",
                pubkey = "6e468422dfb74a5738702a8823b9b28168abab8655faacb6853cd0ee15deee93",
                created_at = 1673347337,
                kind = 1,
                content = "Walled gardens became prisons, and nostr is the first step towards tearing down the prison walls.",
                tags = listOf(
                    listOf(
                        "e",
                        "5c83da77af1dec6d7289834998ad7aafbd9e2191396d75ec3cc27f5a77226f36",
                        "wss://nostr.example.com"
                    ),
                    listOf("p", "f7234bd4c1394dda46d09f35bd384dd30cc552ad5541990f98844fb06676e9ca"),
                    listOf(
                        "a",
                        "30023:f7234bd4c1394dda46d09f35bd384dd30cc552ad5541990f98844fb06676e9ca:abcd",
                        "wss://nostr.example.com"
                    ),
                    listOf("alt", "reply"),
                ),
                sig = "908a15e46fb4d8675bab026fc230a0e3542bfade63da02d542fb78b2a8513fcd0092619a2c8c1221e581946e0191f2af505dfdf8657a414dbca329186f009262"
            )

            dao.addNewEvent(added)
            val selected = dao.event(added.id)
            println(selected)
            call.respondText("Hello World!")
        }
    }
}
