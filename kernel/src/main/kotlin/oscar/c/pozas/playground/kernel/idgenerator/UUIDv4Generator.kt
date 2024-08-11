package oscar.c.pozas.playground.kernel.idgenerator

import java.util.UUID

class UUIDv4Generator : IdGenerator {

    override fun generate(): String = UUID.randomUUID().toString()
}