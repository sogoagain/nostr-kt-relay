package com.sogoagain.relay.models

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

class Tag(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Tag>(Tags)

    var event by Event referencedOn Tags.event
    var i by Tags.i
    var j by Tags.j
    var value by Tags.value
}

object Tags : LongIdTable() {
    val event = reference("event", Events)
    val i = integer("i")
    val j = integer("j")
    val value = text("value")
}
