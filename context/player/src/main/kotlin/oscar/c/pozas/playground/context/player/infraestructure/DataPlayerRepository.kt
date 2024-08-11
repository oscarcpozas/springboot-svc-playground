package oscar.c.pozas.playground.context.player.infraestructure

import jakarta.inject.Named
import oscar.c.pozas.playground.context.player.domain.Player
import oscar.c.pozas.playground.context.player.domain.repository.PlayerRepository
import oscar.c.pozas.playground.context.player.infraestructure.datasource.PlayerStoreDataSource

@Named
class DataPlayerRepository(
    private val storeDataSource: PlayerStoreDataSource
) : PlayerRepository {

    override fun save(player: Player) {
        storeDataSource.save(player)
    }

    override fun getBy(id: Player.Id): Player? {
        TODO("Not yet implemented")
    }
}