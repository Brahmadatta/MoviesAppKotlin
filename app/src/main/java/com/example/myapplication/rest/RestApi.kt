package com.example.myapplication.rest

import com.example.myapplication.model.MovieModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {


    @GET("schedule")
    fun getMovieDetails(@Query("country") country : String,@Query("date") date : String) : Single<List<MovieModel>>


}