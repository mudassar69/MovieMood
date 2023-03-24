package com.app.moviemood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieImageView: ImageView = itemView.findViewById(R.id.movieImageView)
        private val movieTitleTextView: TextView = itemView.findViewById(R.id.movieTitleTextView)
        private val movieDescriptionTextView: TextView =
            itemView.findViewById(R.id.movieDescriptionTextView)

        fun bind(movie: Movie) {
            Glide.with(itemView)
                .load(movie.imageUrl)
                .centerCrop()
                .into(movieImageView)
            movieTitleTextView.text = movie.title
            movieDescriptionTextView.text = movie.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}
