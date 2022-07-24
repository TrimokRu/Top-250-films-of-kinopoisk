package ru.trimok.films.main_activity.domain.models

data class Movie(val countries: MutableList<String>,
                 val filmId: Int,
                 val filmLength: String?,
                 val genres: MutableList<String>,
                 val nameEn: String?,
                 val nameRu: String?,
                 val posterUrl: String,
                 val posterUrlPreview: String,
                 val rating: String?,
                 val year: String
)
