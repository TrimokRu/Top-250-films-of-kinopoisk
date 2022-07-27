package ru.trimok.films.data.storage.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.trimok.films.data.storage.retrofit.data.MovieData
import ru.trimok.films.data.storage.retrofit.data.SingleMovie

interface ApiInterface {
    @GET("/api/v2.2/films/top") fun getTop250Movies(
        @Query("page") page: Int,
        @Query("type") type: String
    ): Call<MovieData>

    @GET("api/v2.2/films/{movieId}")
    fun getMovieById(@Path("movieId") movieId: String): Call<SingleMovie>
}