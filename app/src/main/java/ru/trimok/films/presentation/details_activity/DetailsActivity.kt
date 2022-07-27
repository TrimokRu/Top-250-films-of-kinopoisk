package ru.trimok.films.presentation.details_activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trimok.films.R
import ru.trimok.films.databinding.ActivityDetailsBinding
import ru.trimok.films.domain.models.MovieFull

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var movieId: String

    private val detailsViewModel by viewModel<DetailsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.detailsToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        movieId = intent.getStringExtra("movieId").toString()
        Log.d("NetworkMovieStorage", movieId)

        detailsViewModel.getMovieDetail().observe(this) {
            setUi(it)
        }
        if(detailsViewModel.getMovieDetail().value == null) detailsViewModel.getMovieById(movieId = movieId)

    }

    private fun setUi(movie: MovieFull) {

        with(binding) {
            titleToolbar.text = movie.nameRu
            Picasso.get().load(movie.posterUrl).into(movieImageView)
            movieNameTextView.text = movie.nameRu
            movieYear.text = String.format(getString(R.string.release_year_movie), movie.year)
            movieCountry.text =
                String.format(getString(R.string.country_movie), movie.countries.joinToString())
            movieGenre.text =
                String.format(getString(R.string.genre_movie), movie.genres.joinToString())
            movieRatingKinopoisk.text =
                String.format(getString(R.string.rating_kinopoisk_movie), movie.ratingKinopoisk)
            movieLength.text = String.format(getString(R.string.length_movie), movie.filmLength)
            movieDescriptionTextView.text = movie.description
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}