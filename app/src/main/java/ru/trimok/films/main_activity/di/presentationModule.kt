package ru.trimok.films.main_activity.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.trimok.films.main_activity.presentation.MainViewModel


val presentationModule = module{
    viewModel { MainViewModel(getTop250MoviesUseCase = get()) }
}