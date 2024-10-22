package br.com.koruthos.cursoandroid.repository

import br.com.koruthos.cursoandroid.models.Pokemon

/**
 * Esta classe é usada para retornar uma lista estática de pokemons. Em um aplicativo real, a lista de pokemons
 * seria carregada de uma API ou de um banco de dados.
 */
class PokemonRepository {

    fun getPokemons() = listOf(
        Pokemon(
            nome = "Pikachu",
            tipo = "Elétrico",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/pikachu"
        ),
        Pokemon(
            nome = "Charmander",
            tipo = "Fogo",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/charmander"
        ),
        Pokemon(
            nome = "Squirtle",
            tipo = "Água",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/squirtle"
        ),
        Pokemon(
            nome = "Bulbasaur",
            tipo = "Planta",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/bulbasaur"
        ),
        Pokemon(
            nome = "Jigglypuff",
            tipo = "Fada",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/039.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/jigglypuff"
        ),
        Pokemon(
            nome = "Meowth",
            tipo = "Normal",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/052.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/meowth"
        ),
        Pokemon(
            nome = "Psyduck",
            tipo = "Água",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/054.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/psyduck"
        ),
        Pokemon(
            nome = "Snorlax",
            tipo = "Normal",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/143.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/snorlax"
        ),
        Pokemon(
            nome = "Gengar",
            tipo = "Fantasma/Venenoso",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/gengar"
        ),
        Pokemon(
            nome = "Eevee",
            tipo = "Normal",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/133.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/eevee"
        ),
        Pokemon(
            nome = "Vaporeon",
            tipo = "Água",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/134.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/vaporeon"
        ),
        Pokemon(
            nome = "Jolteon",
            tipo = "Elétrico",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/135.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/jolteon"
        ),
        Pokemon(
            nome = "Flareon",
            tipo = "Fogo",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/136.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/flareon"
        ),
        Pokemon(
            nome = "Machop",
            tipo = "Lutador",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/066.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/machop"
        ),
        Pokemon(
            nome = "Geodude",
            tipo = "Pedra/Terra",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/074.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/geodude"
        ),
        Pokemon(
            nome = "Gastly",
            tipo = "Fantasma/Venenoso",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/092.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/gastly"
        ),
        Pokemon(
            nome = "Abra",
            tipo = "Psíquico",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/063.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/abra"
        ),
        Pokemon(
            nome = "Kabuto",
            tipo = "Pedra/Água",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/140.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/kabuto"
        ),
        Pokemon(
            nome = "Dragonite",
            tipo = "Dragão/Voador",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/149.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/dragonite"
        ),
        Pokemon(
            nome = "Mewtwo",
            tipo = "Psíquico",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/150.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/mewtwo"
        ),
        Pokemon(
            nome = "Mew",
            tipo = "Psíquico",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/151.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/mew"
        ),
        Pokemon(
            nome = "Magikarp",
            tipo = "Água",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/129.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/magikarp"
        ),
        Pokemon(
            nome = "Gyarados",
            tipo = "Água/Voador",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/130.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/gyarados"
        ),
        Pokemon(
            nome = "Lapras",
            tipo = "Água/Gelo",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/131.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/lapras"
        ),
        Pokemon(
            nome = "Ditto",
            tipo = "Normal",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/132.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/ditto"
        ),
        Pokemon(
            nome = "Articuno",
            tipo = "Gelo/Voador",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/144.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/articuno"
        ),
        Pokemon(
            nome = "Zapdos",
            tipo = "Elétrico/Voador",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/145.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/zapdos"
        ),
        Pokemon(
            nome = "Moltres",
            tipo = "Fogo/Voador",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/146.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/moltres"
        ),
        Pokemon(
            nome = "Dratini",
            tipo = "Dragão",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/147.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/dratini"
        ),
        Pokemon(
            nome = "Aerodactyl",
            tipo = "Pedra/Voador",
            urlImagem = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/142.png",
            urlDetalhes = "https://www.pokemon.com/br/pokedex/aerodactyl"
        )
    )

}