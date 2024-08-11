package oscar.c.pozas.playground.context.player.application.command

import jakarta.inject.Named
import oscar.c.pozas.playground.context.player.domain.Player
import oscar.c.pozas.playground.context.player.domain.service.CreatePlayerUseCase
import oscar.c.pozas.playground.context.player.domain.repository.PlayerRepository
import oscar.c.pozas.playground.kernel.event.DomainEventPublisher

@Named
class CreatePlayerCommandHandler(repository: PlayerRepository) {

    private val createPlayer = CreatePlayerUseCase(repository)

    fun handle(command: CreatePlayerCommand) {
        createPlayer(Player.Id(command.id), Player.Name(command.name))
    }
}

data class CreatePlayerCommand(
    val id: String,
    val name: String,
)
