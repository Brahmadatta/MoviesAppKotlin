package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.MovieItemModelBinding
import com.example.myapplication.model.MovieModel
import com.example.myapplication.util.getProgressDrawable
import com.example.myapplication.util.loadImage
import kotlinx.android.synthetic.main.movie_item_model.view.*

class MovieAdapter(private val movieList: ArrayList<MovieModel>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_model,parent,false)
//        return MovieViewHolder(view)

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<MovieItemModelBinding>(inflater,R.layout.movie_item_model,parent,false)
        return MovieViewHolder(view)
    }

    fun updateList(list: ArrayList<MovieModel>)
    {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {


        holder.view.movies = movieList[position]

//        holder.itemView.movie_name.text = movieList[position].name
//        val image = movieList[position].show?.image
//        if (image != null)
//        {
//            image.medium?.let { holder.itemView.movie_image.loadImage(it, getProgressDrawable(holder.itemView.context)) }
//        }else{
//            Glide.with(holder.itemView.movie_image).load(R.drawable.ic_launcher_background).into(holder.itemView.movie_image)
//        }
//
//        holder.itemView.setOnClickListener {
//            val action = MoviesFragmentDirections.actionMovies(movieList[position])
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(var view: MovieItemModelBinding) : RecyclerView.ViewHolder(view.root), View.OnClickListener{
        override fun onClick(p0: View?) {

        }

//        var moviename : String? = null
//        var movieImageUrl : String? = null
//
//        fun bindView(movieList: ArrayList<MovieModel>)
//        {
//
//            var movieName = itemView.findViewById(R.id.movie_name) as TextView
//            var movieUrl = itemView.findViewById(R.id.movie_image) as ImageView
//
//            movieImageUrl
//
//            movieUrl.loadImage()
//
//        }
    }

}