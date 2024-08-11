package oscar.c.pozas.playground.context.player.domain

import java.time.ZonedDateTime
import java.util.UUID
import oscar.c.pozas.playground.kernel.event.Aggregate
import oscar.c.pozas.playground.kernel.event.DomainEvent

data class Player private constructor(
    val id: Id,
    val name: Name,
    val createdOn: ZonedDateTime
): Aggregate() {

    @JvmInline value class Id(val value: UUID) {

        constructor(id: String) : this(UUID.fromString(id))

        override fun toString(): String = value.toString()
    }

    @JvmInline value class Name(val value: String)

    companion object {
        fun create(id: Id, name: Name): Player =
            Player(id, name, ZonedDateTime.now())
                .also { it.pushEvent(PlayerCreatedEvent(id.toString())) }
    }
}

data class PlayerCreatedEvent(val id: String) : DomainEvent {

    override fun getType(): String  = "player.player.created"
}

