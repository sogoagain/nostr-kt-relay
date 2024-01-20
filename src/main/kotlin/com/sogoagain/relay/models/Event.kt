package com.sogoagain.relay.models

import com.sogoagain.relay.domain.NostrEvent
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable

class Event(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, Event>(Events)

    var pubkey by Events.pubkey
    var createdAt by Events.createdAt
    var kind by Events.kind
    var content by Events.content
    var sig by Events.sig
    val tags by Tag referrersOn Tags.event

    fun domain() = NostrEvent(
        id = id.value,
        pubkey = pubkey,
        created_at = createdAt,
        kind = kind,
        tags = tags.groupBy { it.i }
            .entries
            .sortedBy { it.key }
            .map { (_, value) ->
                value.sortedBy { it.j }.map { it.value }
            },
        content = content,
        sig = sig
    )
}

object Events : IdTable<String>() {
    override val id = varchar("id", length = 64).entityId()
    val pubkey = varchar("pubkey", length = 64)
    val createdAt = long("created_at")
    val kind = integer("kind")
    val content = text("content")
    val sig = varchar("sig", length = 128)
    override val primaryKey = PrimaryKey(id)
}
