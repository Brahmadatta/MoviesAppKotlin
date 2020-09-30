package com.example.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.model.MovieModel
import com.example.myapplication.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private val movieAdapter = MovieAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        movieViewModel.movies.observe(viewLifecycleOwner,movieListObserver)
        movieViewModel.getMovieDetails()



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private val movieListObserver = Observer<ArrayList<MovieModel>> { list ->
        list?.let {
            movie_recyclerView?.layoutManager = LinearLayoutManager(context)
            movieAdapter.updateList(it)
            movie_recyclerView.adapter = movieAdapter
        }
    }

}