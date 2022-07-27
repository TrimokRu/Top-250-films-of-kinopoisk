package ru.trimok.films.domain.repository

import ru.trimok.films.domain.models.MovieFull
import ru.trimok.films.domain.models.MovieShort

interface MovieRepository {
    fun getTop250Movies(page: Int): MutableList<MovieShort>
    fun getMovieById(id: String): MovieFull?
}