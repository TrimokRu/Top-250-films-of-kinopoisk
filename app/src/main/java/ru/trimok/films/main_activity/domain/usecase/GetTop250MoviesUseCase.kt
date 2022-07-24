package ru.trimok.films.main_activity.domain.usecase

import ru.trimok.films.main_activity.domain.models.Movie
import ru.trimok.films.main_activity.domain.repository.MovieRepository

class GetTop250MoviesUseCase(private val movieRepository: MovieRepository) {
    fun execute(page: Int): MutableList<Movie>{
        return movieRepository.getTop250Movies(page)
    }
}