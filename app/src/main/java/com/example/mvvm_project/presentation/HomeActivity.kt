package com.example.mvvm_project.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm_project.R
import com.example.mvvm_project.databinding.ActivityHomeBinding
import com.example.mvvm_project.presentation.artist.ArtistActivity
import com.example.mvvm_project.presentation.movie.MovieActivity
import com.example.mvvm_project.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.btnMovies.setOnClickListener {
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }
        binding.btnArtists.setOnClickListener {
            val intent = Intent(this,ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.btnTvShows.setOnClickListener {
            val intent = Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}