package ru.trimok.films.data.repository

import ru.trimok.films.data.storage.network.MovieStorage
import ru.trimok.films.domain.models.MovieFull
import ru.trimok.films.domain.models.MovieShort
import ru.trimok.films.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieStorage: MovieStorage): MovieRepository {
    override fun getTop250Movies(page: Int): MutableList<MovieShort> {
        return movieStorage.getTop250Movie(page = page)
    }

    override fun getMovieById(id: String): MovieFull? {
        return  movieStorage.getMovieById(id)
    }
}