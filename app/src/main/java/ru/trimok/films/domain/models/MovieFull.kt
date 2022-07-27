package ru.trimok.films.domain.models

import ru.trimok.films.data.storage.retrofit.data.Country
import ru.trimok.films.data.storage.retrofit.data.Genre

data class MovieFull(
    val countries: MutableList<String>,
    val description: String,
    val filmLength: Int,
    val genres: MutableList<String>,
    val kinopoiskId: Int,
    val nameOriginal: String,
    val nameRu: String,
    val posterUrl: String,
    val ratingImdb: Double,
    val ratingKinopoisk: Double,
    val slogan: String,
    val webUrl: String,
    val year: Int
)