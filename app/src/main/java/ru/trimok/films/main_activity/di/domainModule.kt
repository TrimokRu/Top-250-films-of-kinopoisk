package ru.trimok.films.main_activity.di

import org.koin.dsl.module
import ru.trimok.films.main_activity.domain.usecase.GetTop250MoviesUseCase

val domainModule = module {
    factory {
        GetTop250MoviesUseCase(movieRepository = get())
    }
}