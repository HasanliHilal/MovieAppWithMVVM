package com.example.mvvm_project.presentation.tvshow

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
import com.example.mvvm_project.databinding.ActivityMovieBinding
import com.example.mvvm_project.databinding.ActivityTvShowBinding
import com.example.mvvm_project.presentation.di.Injector
import com.example.mvvm_project.presentation.movie.MovieAdapter
import com.example.mvvm_project.presentation.movie.MovieViewModel
import com.example.mvvm_project.presentation.movie.MovieViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding:ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)
        initRecylerView()
    }

    private fun initRecylerView() {
        binding.recylistTvShow.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.recylistTvShow.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.prgBarTvShow.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.prgBarTvShow.visibility = View.GONE

            } else {
                binding.prgBarTvShow.visibility = View.GONE
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
                updateTvShows()
                true
            }
            else -> this.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        binding.prgBarTvShow.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.prgBarTvShow.visibility = View.GONE
            } else {
                binding.prgBarTvShow.visibility = View.GONE
            }
        })
    }
}