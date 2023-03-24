package com.app.moviemood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var moodAdapter: MoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMoodAdapter()
        setupRecyclerView()
    }

    private fun initMoodAdapter() {
        moodAdapter = MoodAdapter(MoodData.moods) { mood ->
            // Handle mood selection
            onMoodSelected(mood)
        }
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.mood_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Set the number of columns for the grid
        recyclerView.adapter = moodAdapter
    }

    private fun onMoodSelected(mood: Mood) {
        val intent = Intent(this, MovieListActivity::class.java).apply {
            putExtra("mood", mood.name)
        }
        startActivity(intent)
    }
}
