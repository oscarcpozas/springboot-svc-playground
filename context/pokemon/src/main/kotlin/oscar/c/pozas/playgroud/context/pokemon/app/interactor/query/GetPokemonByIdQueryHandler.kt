package oscar.c.pozas.playgroud.context.pokemon.app.interactor.query

import oscar.c.pozas.playgroud.context.pokemon.domain.Pokemon
import oscar.c.pozas.playgroud.context.pokemon.domain.service.PokemonFinder

class GetPokemonByIdCommandHandler(private val pokemonFinder: PokemonFinder) {

    operator fun invoke(command: GetPokemonByIdQuery): PokemonQueryResult =
        pokemonFinder.findBy(Pokemon.Id(command.id))?.toResult() ?: throw Error.PokemonNotFound(command.id)

    private fun Pokemon.toResult() = PokemonQueryResult(id = id.value, name = name.toString())

    sealed class Error : RuntimeException() {
        class PokemonNotFound(val id: Int) : Error()
    }
}

data class GetPokemonByIdQuery(val id: Int)

data class PokemonQueryResult(val id: Int, val name: String)
