package ru.trimok.films.di

import org.koin.dsl.module
import ru.trimok.films.domain.usecase.GetMovieByIdUseCase
import ru.trimok.films.domain.usecase.GetTop250MoviesUseCase

val domainModule = module {
    factory {
        GetTop250MoviesUseCase(movieRepository = get())
    }
    factory { GetMovieByIdUseCase(movieRepository = get ()) }
}