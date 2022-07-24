package ru.trimok.films.main_activity.data.storage.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.trimok.films.main_activity.data.storage.retrofit.data.MovieData

interface ApiInterface {

    @Headers(
        "X-API-KEY: 331c4c37-4582-46cb-b619-6b0cc192f981",
        "Content-Type: application/json"
    )
    @GET("/api/v2.2/films/top") fun getTop250Movies(
        @Query("page") page: Int,
        @Query("type") type: String
    ): Call<MovieData>
}