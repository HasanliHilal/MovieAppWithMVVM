package com.example.mvvm_project.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_project.R
import com.example.mvvm_project.databinding.ActivityArtistBinding
import com.example.mvvm_project.databinding.ActivityTvShowBinding
import com.example.mvvm_project.presentation.di.Injector
import com.example.mvvm_project.presentation.tvshow.TvShowAdapter
import com.example.mvvm_project.presentation.tvshow.TvShowViewModel
import com.example.mvvm_project.presentation.tvshow.TvShowViewModelFactory
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel = ViewModelProvider(this, factory)
            .get(ArtistViewModel::class.java)
        initRecylerView()
    }
    private fun initRecylerView() {
        binding.recylistArtist.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.recylistArtist.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.prgBarArtist.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.prgBarArtist.visibility = View.GONE

            } else {
                binding.prgBarArtist.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateArtists()
                true
            }
            else -> this.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists() {
        binding.prgBarArtist.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.prgBarArtist.visibility = View.GONE
            } else {
                binding.prgBarArtist.visibility = View.GONE
            }
        })
    }
}