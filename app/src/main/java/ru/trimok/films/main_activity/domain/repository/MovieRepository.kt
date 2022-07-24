package ru.trimok.films.main_activity.domain.repository

import ru.trimok.films.main_activity.domain.models.Movie

interface MovieRepository {
    fun getTop250Movies(page: Int): MutableList<Movie>
}