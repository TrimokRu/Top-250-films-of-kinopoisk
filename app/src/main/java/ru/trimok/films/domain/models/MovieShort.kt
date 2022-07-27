package ru.trimok.films.domain.models

data class MovieShort(val countries: MutableList<String>,
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
