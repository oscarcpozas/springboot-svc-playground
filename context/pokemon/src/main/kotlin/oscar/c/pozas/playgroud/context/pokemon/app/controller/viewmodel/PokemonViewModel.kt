package oscar.c.pozas.playgroud.context.pokemon.app.controller.viewmodel

import oscar.c.pozas.playgroud.context.pokemon.app.interactor.query.PokemonQueryResult

data class PokemonViewModel(
    val id: String,
    val name: String
)

fun PokemonQueryResult.toViewModel(): PokemonViewModel = PokemonViewModel(id, name)
