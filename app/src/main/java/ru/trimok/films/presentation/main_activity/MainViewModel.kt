package ru.trimok.films.presentation.main_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import ru.trimok.films.domain.models.MovieShort
import ru.trimok.films.domain.usecase.GetTop250MoviesUseCase

class MainViewModel(private val getTop250MoviesUseCase: GetTop250MoviesUseCase):ViewModel() {

    private val moviesMutableList = MutableLiveData<MutableList<MovieShort>>()
    fun getMoviesMutableList(): LiveData<MutableList<MovieShort>> = moviesMutableList

    fun getTop250Movies(page: Int){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                moviesMutableList.postValue(getTop250MoviesUseCase.execute(page))
            }
        }
    }
}