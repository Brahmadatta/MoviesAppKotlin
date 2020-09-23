package com.example.myapplication.rest

import com.example.myapplication.model.MovieModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RestApiService {

    private val BASE_URL = "http://api.tvmaze.com/"

    val restApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(RestApi::class.java)


    fun getMovieDetailsData() : Single<List<MovieModel>>{
        return restApi.getMovieDetails("US","2019-12-01")
    }

}