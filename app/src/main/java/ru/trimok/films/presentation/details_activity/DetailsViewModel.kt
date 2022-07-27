package ru.trimok.films.presentation.details_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.trimok.films.domain.models.MovieFull
import ru.trimok.films.domain.usecase.GetMovieByIdUseCase

class DetailsViewModel(private val getMovieByIdUseCase: GetMovieByIdUseCase):ViewModel() {

    private val movieDetail = MutableLiveData<MovieFull>()
    fun getMovieDetail(): LiveData<MovieFull> = movieDetail

    fun getMovieById(movieId: String){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                val movieFull = getMovieByIdUseCase.execute(movieId = movieId)
                movieFull?.let { movieDetail.postValue(it) }
            }
        }
    }
}