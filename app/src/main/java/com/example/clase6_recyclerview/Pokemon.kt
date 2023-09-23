package com.example.clase6_recyclerview

data class Pokemon (
    val id: Int,
    val name: String,
    val life: Int,
    val atq: Int,
    val def: Int,
    val type: TipoPokemon,
    val image: String?
    )

enum class TipoPokemon {
    PLANTA, AGUA, FUEGO, LUCHA, ELECTRICO
}