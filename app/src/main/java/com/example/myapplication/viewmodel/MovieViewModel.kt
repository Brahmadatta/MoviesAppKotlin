package com.example.myapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.MovieModel
import com.example.myapplication.rest.RestApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MovieViewModel(application: Application) : AndroidViewModel(application){


    private val compositeDisposable = CompositeDisposable()

    private val restApiService = RestApiService()


    val movies by lazy {
        MutableLiveData<ArrayList<MovieModel>>()
    }

    val loading by lazy {
        MutableLiveData<Boolean>()
    }

    val loadingError by lazy {
        MutableLiveData<Boolean>()
    }


    fun getMovieDetails()
    {
        compositeDisposable.add(
            restApiService.getMovieDetailsData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ArrayList<MovieModel>>(){
                    override fun onSuccess(list : ArrayList<MovieModel>) {

                        movies.postValue(list)
                    }

                    override fun onError(e: Throwable) {

                        Log.e("error",e.message)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}