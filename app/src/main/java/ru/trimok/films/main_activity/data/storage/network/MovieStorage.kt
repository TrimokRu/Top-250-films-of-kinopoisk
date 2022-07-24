package ru.trimok.films.main_activity.data.storage.network

import ru.trimok.films.main_activity.domain.models.Movie


interface MovieStorage {
    fun getTop250Movie(page: Int): MutableList<Movie>
}