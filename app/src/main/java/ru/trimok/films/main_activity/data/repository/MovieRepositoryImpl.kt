package ru.trimok.films.main_activity.data.repository

import ru.trimok.films.main_activity.data.storage.network.MovieStorage
import ru.trimok.films.main_activity.domain.models.Movie
import ru.trimok.films.main_activity.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieStorage: MovieStorage): MovieRepository {
    override fun getTop250Movies(page: Int): MutableList<Movie> {
        return movieStorage.getTop250Movie(page = page)
    }
}