package ru.trimok.films.main_activity.di

import org.koin.dsl.module
import ru.trimok.films.main_activity.data.repository.MovieRepositoryImpl
import ru.trimok.films.main_activity.data.storage.network.MovieStorage
import ru.trimok.films.main_activity.data.storage.network.NetworkMovieStorage
import ru.trimok.films.main_activity.domain.repository.MovieRepository

val dataModule = module{
    single<MovieStorage>{
        NetworkMovieStorage()
    }
    single<MovieRepository>{
        MovieRepositoryImpl(movieStorage = get())
    }
}