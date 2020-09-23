package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.myapplication.R
import com.example.myapplication.model.MovieModel
import com.example.myapplication.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.movies.observe(this,movieListObserver)
        movieViewModel.getMovieDetails()


    }

    private val movieListObserver = Observer<List<MovieModel>> { list ->
        list?.let {
            Log.e("data",it.toString())
        }
    }
}