package oscar.c.pozas.playground.context.player.domain.service

import oscar.c.pozas.playground.context.player.domain.Player
import oscar.c.pozas.playground.context.player.domain.repository.PlayerRepository

class GetPlayerByIdUseCase(private val repository: PlayerRepository) {

    operator fun invoke(id: Player.Id): Player? = repository.getBy(id)
}