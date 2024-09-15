package com.annisa.moviecard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.annisa.moviecard.R
import com.annisa.moviecard.RecycleViewCardMovie
import com.annisa.moviecard.model.ModelMovie

class MovieAdapter constructor(
    private val getActivity: RecycleViewCardMovie,// bisa diklik
    private val movieList: List<ModelMovie>,
    private val itemClickListener: (Int) -> Unit

) :

// private val itemClickListener: (Int) -> Unit
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtMovie: TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie: ImageView = itemView.findViewById(R.id.imgMovie)
        val cardMovie: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.txtMovie.text = movie.title
        holder.imgMovie.setImageResource(movie.image)

        // Menambahkan event klik
        holder.itemView.setOnClickListener {
            itemClickListener(position)
        }
    }
}