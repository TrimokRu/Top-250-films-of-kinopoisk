package ru.trimok.films.presentation.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trimok.films.databinding.ActivityMainBinding
import ru.trimok.films.presentation.main_activity.adapters.MoviesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val moviesAdapter = MoviesAdapter(context = this)
        binding.filmsRecyclerView.adapter = moviesAdapter

        mainViewModel.getMoviesMutableList().observe(this){
            moviesAdapter.addItems(it)
        }
        if(mainViewModel.getMoviesMutableList().value.isNullOrEmpty())
            mainViewModel.getTop250Movies(1)


    }
}