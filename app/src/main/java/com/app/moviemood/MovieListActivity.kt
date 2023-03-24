package com.app.moviemood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MovieListActivity : AppCompatActivity() {

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val mood = intent.getStringExtra("mood")

        // Set up the RecyclerView
        movieRecyclerView = findViewById(R.id.movieRecyclerView)
        movieRecyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch the curated movie list based on the selected mood
        val movieList = fetchCuratedMovies(mood)

        // Set up the adapter and attach it to the RecyclerView
        movieAdapter = MovieAdapter(movieList)
        movieRecyclerView.adapter = movieAdapter
    }

    private fun fetchCuratedMovies(mood: String?): List<Movie> {
        // This is just a placeholder function to fetch the curated movie list.
        // You should replace this with a function that fetches movies from an API or a database.
        return when (mood) {
            "Happy" -> listOf(
                Movie("Movie 1", "https://via.placeholder.com/150", "Description 1"),
                Movie("Movie 2", "https://via.placeholder.com/150", "Description 2")
            )
            "Sad" -> listOf(
                Movie("Movie 3", "https://via.placeholder.com/150", "Description 3"),
                Movie("Movie 4", "https://via.placeholder.com/150", "Description 4")
            )
            else -> Collections.emptyList()
        }
    }
}
