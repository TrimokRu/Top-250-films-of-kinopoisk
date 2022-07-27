package ru.trimok.films.domain.usecase

import ru.trimok.films.domain.models.MovieShort
import ru.trimok.films.domain.repository.MovieRepository

class GetTop250MoviesUseCase(private val movieRepository: MovieRepository) {
    fun execute(page: Int): MutableList<MovieShort>{
        return movieRepository.getTop250Movies(page)
    }
}