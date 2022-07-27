package ru.trimok.films.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.trimok.films.domain.usecase.GetMovieByIdUseCase
import ru.trimok.films.presentation.details_activity.DetailsViewModel
import ru.trimok.films.presentation.main_activity.MainViewModel


val presentationModule = module{
    viewModel { MainViewModel(getTop250MoviesUseCase = get()) }
    viewModel { DetailsViewModel(getMovieByIdUseCase = get()) }
}