package ru.trimok.films.main_activity.data.storage.network

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.trimok.films.main_activity.data.storage.retrofit.ApiInterface
import ru.trimok.films.main_activity.data.storage.retrofit.data.Country
import ru.trimok.films.main_activity.data.storage.retrofit.data.Genre
import ru.trimok.films.main_activity.domain.models.Movie
import java.lang.Exception

class NetworkMovieStorage: MovieStorage {

    private val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .build()
        .create(ApiInterface::class.java)

    override fun getTop250Movie(page: Int): MutableList<Movie> {
        val movies = mutableListOf<Movie>()
        val retrofitData = retrofitBuilder.getTop250Movies(page = page, type = "TOP_250_BEST_FILMS")
        val response = retrofitData.execute()
        try{
            for(movie in response.body()!!.films){
                movies.add(Movie(
                    countries = countriesListToMutableList(movie.countries),
                    filmId = movie.filmId,
                    genres = genresListToMutableList(movie.genres),
                    nameEn = movie.nameEn,
                    nameRu = movie.nameRu,
                    posterUrl = movie.posterUrl,
                    posterUrlPreview = movie.posterUrlPreview,
                    filmLength = movie.filmLength,
                    rating = movie.rating,
                    year = movie.year
                ))
            }
        }catch (e: Exception){
            Log.d("NetworkMovieStorage", e.message.toString())
        }
        return movies
    }


    private fun countriesListToMutableList(countries: List<Country>): MutableList<String>{
        val res = mutableListOf<String>()
        for(country in countries)
            res.add(country.country)
        return res
    }

    private fun genresListToMutableList(genres: List<Genre>): MutableList<String>{
        val res = mutableListOf<String>()
        for(genre in genres)
            res.add(genre.genre)
        return res
    }
}