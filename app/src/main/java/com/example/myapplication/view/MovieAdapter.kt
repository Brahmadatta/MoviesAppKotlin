package com.example.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.MovieModel
import com.example.myapplication.util.getProgressDrawable
import com.example.myapplication.util.loadImage
import kotlinx.android.synthetic.main.movie_item_model.view.*

class MovieAdapter(private val movieList: ArrayList<MovieModel>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_model,parent,false)
        return MovieViewHolder(view)
    }

    fun updateList(list: ArrayList<MovieModel>)
    {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.itemView.movie_name.text = movieList[position].name
        val image = movieList[position].show.image
        if (image != null)
        {
            holder.itemView.movie_image.loadImage(image.medium, getProgressDrawable(holder.itemView.context))
        }else{
            Glide.with(holder.itemView.movie_image).load(R.drawable.ic_launcher_background).into(holder.itemView.movie_image)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

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