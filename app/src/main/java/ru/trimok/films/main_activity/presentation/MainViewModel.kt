package ru.trimok.films.main_activity.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.trimok.films.main_activity.domain.models.Movie
import ru.trimok.films.main_activity.domain.usecase.GetTop250MoviesUseCase

class MainViewModel(private val getTop250MoviesUseCase: GetTop250MoviesUseCase):ViewModel() {

    private val moviesMutableList = MutableLiveData<MutableList<Movie>>()
    fun getMoviesMutableList(): LiveData<MutableList<Movie>> = moviesMutableList

    fun getTop250Movies(page: Int){
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                moviesMutableList.postValue(getTop250MoviesUseCase.execute(page))
            }
        }

    }
}