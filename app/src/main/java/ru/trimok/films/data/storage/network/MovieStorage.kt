package ru.trimok.films.data.storage.network

import ru.trimok.films.domain.models.MovieFull
import ru.trimok.films.domain.models.MovieShort


interface MovieStorage {
    fun getTop250Movie(page: Int): MutableList<MovieShort>
    fun getMovieById(movieId: String): MovieFull?
}