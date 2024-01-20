package com.sogoagain.relay.dao

import com.sogoagain.relay.dao.DatabaseSingleton.dbQuery
import com.sogoagain.relay.domain.NostrEvent
import com.sogoagain.relay.models.Event
import com.sogoagain.relay.models.Tag

class NostrEventStorageImpl : NostrEventStorage {
    override suspend fun addNewEvent(nostrEvent: NostrEvent) = dbQuery {
        val event = Event.new(nostrEvent.id) {
            pubkey = nostrEvent.pubkey
            createdAt = nostrEvent.created_at
            kind = nostrEvent.kind
            content = nostrEvent.content
            sig = nostrEvent.sig
        }
        nostrEvent.tags.forEachIndexed { i, tags ->
            tags.forEachIndexed { j, value ->
                Tag.new {
                    this.event = event
                    this.i = i
                    this.j = j
                    this.value = value
                }
            }
        }
    }

    override suspend fun event(id: String): NostrEvent? = dbQuery {
        return@dbQuery Event.findById(id)?.domain()
    }
}

val dao: NostrEventStorage = NostrEventStorageImpl()
