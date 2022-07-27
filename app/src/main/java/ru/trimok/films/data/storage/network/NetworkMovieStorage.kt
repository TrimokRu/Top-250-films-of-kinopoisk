package ru.trimok.films.data.storage.network

import android.content.Context
import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.trimok.films.R
import ru.trimok.films.data.storage.retrofit.ApiInterface
import ru.trimok.films.data.storage.retrofit.data.Country
import ru.trimok.films.data.storage.retrofit.data.Genre
import ru.trimok.films.domain.models.MovieFull
import ru.trimok.films.domain.models.MovieShort
import java.lang.Exception

class NetworkMovieStorage(context: Context): MovieStorage {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{
            val request = it.request().newBuilder()
                .addHeader("X-API-KEY", context.getString(R.string.API_KEY))
                .addHeader("Content-Type", "application/json")
                .build()
            return@addInterceptor it.proceed(request)
        }
        .build()

    private val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(context.getString(R.string.BASE_URL))
        .client(okHttpClient)
        .build()
        .create(ApiInterface::class.java)

    override fun getTop250Movie(page: Int): MutableList<MovieShort> {
        val movies = mutableListOf<MovieShort>()
        val retrofitData = retrofitBuilder.getTop250Movies(page = page, type = "TOP_250_BEST_FILMS")
        val response = retrofitData.execute()
        try{
            for(movie in response.body()!!.films){
                movies.add(
                    MovieShort(
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
                )
                )
            }
        }catch (e: Exception){
            Log.d("NetworkMovieStorage", e.message.toString())
        }
        return movies
    }

    override fun getMovieById(movieId: String): MovieFull? {
        val retrofitData = retrofitBuilder.getMovieById(movieId = movieId)
        val response = retrofitData.execute()
        Log.d("NetworkMovieStorage", movieId)
        try {
            with(response.body()!!){
                return MovieFull(
                    countries = countriesListToMutableList(countries),
                    description = description,
                    filmLength = filmLength,
                    genres = genresListToMutableList(genres),
                    kinopoiskId = kinopoiskId,
                    nameOriginal = nameOriginal,
                    nameRu = nameRu,
                    webUrl = webUrl,
                    year = year,
                    posterUrl =  posterUrl,
                    ratingImdb = ratingImdb,
                    ratingKinopoisk = ratingKinopoisk,
                    slogan = slogan
                )
            }
        }catch (e: Exception){
            Log.d("NetworkMovieStorage", e.toString())
            return null
        }
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