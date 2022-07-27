package ru.trimok.films.domain.usecase

import ru.trimok.films.domain.models.MovieFull
import ru.trimok.films.domain.models.MovieShort
import ru.trimok.films.domain.repository.MovieRepository

class GetMovieByIdUseCase(private val movieRepository: MovieRepository) {
    fun execute(movieId: String): MovieFull? {
        return movieRepository.getMovieById(movieId)
    }
}