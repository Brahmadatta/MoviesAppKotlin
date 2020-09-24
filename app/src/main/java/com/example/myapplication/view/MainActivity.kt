package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.MovieModel
import com.example.myapplication.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel
    private val movieAdapter = MovieAdapter(ArrayList())
    private val linearLayoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.movies.observe(this,movieListObserver)
        movieViewModel.getMovieDetails()

        movie_recyclerView.layoutManager = linearLayoutManager
        movie_recyclerView.setHasFixedSize(true)


    }

    private val movieListObserver = Observer<ArrayList<MovieModel>> { list ->
        list?.let {
            movieAdapter.updateList(it)
            movie_recyclerView.adapter = movieAdapter
        }
    }
}