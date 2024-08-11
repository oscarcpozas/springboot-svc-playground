package oscar.c.pozas.playground.kernel.event

abstract class Aggregate {

    private val events = mutableListOf<DomainEvent>()

    fun pushEvent(event: DomainEvent) {
        events.add(event)
    }

    fun pullEvents() = events
}