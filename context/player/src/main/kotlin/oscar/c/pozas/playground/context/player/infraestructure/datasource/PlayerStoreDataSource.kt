package oscar.c.pozas.playground.context.player.infraestructure.datasource

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import oscar.c.pozas.playground.context.player.domain.Player
import oscar.c.pozas.playground.spring.annotation.DataSource

@DataSource
class PlayerStoreDataSource {

    init {
        // TODO: Move to a connection pool, like Hikari -- That's create a connection per every call to the API (DANGER!)
        Database.connect(url = "jdbc:postgresql://[::1]:15432/pokemon", driver = "org.postgresql.Driver", user = "root", password = "")
    }

    fun save(player: Player) {
        transaction {
            PlayerTable.insert {
                it[id] = player.id.value
                it[name] = player.name.value
                it[createdOn] = player.createdOn.toString()
            }
        }
    }

    fun getById(id: Player.Id): Player? = TODO()
}

private object PlayerTable : Table(name = "player") {
    val id = uuid("id")
    val name = varchar("name", 180)
    val createdOn = varchar("created_on", 50)

    override val primaryKey = PrimaryKey(id)
}

