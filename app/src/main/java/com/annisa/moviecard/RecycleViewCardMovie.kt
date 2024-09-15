package com.annisa.moviecard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.annisa.moviecard.adapter.MovieAdapter
import com.annisa.moviecard.model.ModelMovie


class RecycleViewCardMovie : AppCompatActivity() {
    private var recycleview: RecyclerView? = null
    private var movieAdapter: MovieAdapter? = null
    private var movieList = mutableListOf<ModelMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_card)

        recycleview = findViewById(R.id.rvMovieList) as RecyclerView

        movieAdapter = MovieAdapter(this@RecycleViewCardMovie, movieList) { position ->
            // Call the method to show details of the movie at the clicked position
            showDetailDialog(position)
        }


        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recycleview!!.layoutManager = layoutManager
        recycleview!!.adapter = movieAdapter

        prepareMovieList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareMovieList() {
        var movie = ModelMovie("Avatar", R.drawable.avatar)
        movieList.add(movie)

        movie = ModelMovie("Batman", R.drawable.batman)
        movieList.add(movie)
        movie = ModelMovie("End Game", R.drawable.end_game)
        movieList.add(movie)
        movie = ModelMovie("Hulk", R.drawable.hulk)
        movieList.add(movie)
        movie = ModelMovie("Inception", R.drawable.inception)
        movieList.add(movie)
        movie = ModelMovie("Jumanji", R.drawable.jumanji)
        movieList.add(movie)
        movie = ModelMovie("Lucy", R.drawable.lucy)
        movieList.add(movie)
        movie = ModelMovie("Jurassic World", R.drawable.jurassic_world)
        movieList.add(movie)
        movie = ModelMovie("Spider Man", R.drawable.spider_man)
        movieList.add(movie)
        movie = ModelMovie("Venom", R.drawable.venom)
        movieList.add(movie)

        movieAdapter!!.notifyDataSetChanged()
    }

    private fun showDetailDialog(position: Int) {
        val intent = Intent(this, PhotoDetailActivity::class.java) // Pastikan kelas "PhotoDetail" benar
        intent.putExtra("imageResId", movieList[position].image) // Mengirim imageResId ke Activity PhotoDetail
        intent.putExtra("title", movieList[position].title)
        startActivity(intent)
    }
}