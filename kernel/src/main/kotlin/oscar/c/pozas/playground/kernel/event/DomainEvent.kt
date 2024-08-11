package oscar.c.pozas.playground.kernel.event

interface DomainEvent {

    fun getType(): String
}