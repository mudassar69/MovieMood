package com.app.moviemood

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoodAdapter(private val moods: List<Mood>, private val onMoodSelected: (Mood) -> Unit) :
    RecyclerView.Adapter<MoodAdapter.MoodViewHolder>() {

    inner class MoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val moodImageView: ImageView = itemView.findViewById(R.id.moodImageView)
        private val moodNameTextView: TextView = itemView.findViewById(R.id.moodNameTextView)
        private val rootLayout: LinearLayout = itemView.findViewById(R.id.rootLayout)

        fun bind(mood: Mood) {
            Glide.with(itemView)
                .load(mood.imageUrl)
                .centerCrop()
                .into(moodImageView)
            moodNameTextView.text = mood.name
            rootLayout.setOnClickListener {
                onMoodSelected(mood)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mood, parent, false)
        return MoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        holder.bind(moods[position])
    }

    override fun getItemCount(): Int = moods.size
}
