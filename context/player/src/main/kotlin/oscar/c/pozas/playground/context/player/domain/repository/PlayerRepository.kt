package oscar.c.pozas.playground.context.player.domain.repository

import oscar.c.pozas.playground.context.player.domain.Player

interface PlayerRepository {

    fun save(player: Player)

    fun getBy(id: Player.Id): Player?
}