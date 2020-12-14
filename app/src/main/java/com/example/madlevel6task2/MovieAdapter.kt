package com.example.madlevel6task2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movie_info.view.*
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        @SuppressLint("StringFormatInvalid")
        fun bind(movie: Movie) {

            itemView.tvMovieNumber.text =
                    itemView.resources.getString(R.string.tv_movie_number, adapterPosition + 1)

            Glide.with(context).load(movie.getPosterUrl()).into(itemView.ivPoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])
}