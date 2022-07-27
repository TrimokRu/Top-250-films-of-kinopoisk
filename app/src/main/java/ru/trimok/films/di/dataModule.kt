package ru.trimok.films.di

import org.koin.dsl.module
import ru.trimok.films.data.repository.MovieRepositoryImpl
import ru.trimok.films.data.storage.network.MovieStorage
import ru.trimok.films.data.storage.network.NetworkMovieStorage
import ru.trimok.films.domain.repository.MovieRepository

val dataModule = module{
    single<MovieStorage>{
        NetworkMovieStorage(context = get())
    }
    single<MovieRepository>{
        MovieRepositoryImpl(movieStorage = get())
    }
}