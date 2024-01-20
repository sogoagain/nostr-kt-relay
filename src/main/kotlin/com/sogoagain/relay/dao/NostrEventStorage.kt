package com.sogoagain.relay.dao

import com.sogoagain.relay.domain.NostrEvent


interface NostrEventStorage {
    suspend fun addNewEvent(nostrEvent: NostrEvent)
    suspend fun event(id: String): NostrEvent?
}
