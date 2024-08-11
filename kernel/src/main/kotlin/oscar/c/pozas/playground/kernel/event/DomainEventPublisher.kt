package oscar.c.pozas.playground.kernel.event

interface DomainEventPublisher {
    fun <E : DomainEvent> publish(event: E)
    fun <E : DomainEvent> publish(events: List<E>)
}