package oscar.c.pozas.playground.context.player.domain.service

import oscar.c.pozas.playground.context.player.domain.repository.PlayerRepository
import oscar.c.pozas.playground.context.player.domain.Player
import oscar.c.pozas.playground.kernel.event.DomainEventPublisher

class CreatePlayerUseCase(private val repository: PlayerRepository) {

    operator fun invoke(id: Player.Id, name: Player.Name) {
        val player = Player.create(id, name)
        repository.save(player)

//        eventPublisher.publish(player.pullEvents())
    }
}