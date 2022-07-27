package ru.trimok.films.presentation.main_activity.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.trimok.films.R
import ru.trimok.films.databinding.FilmsListItemBinding
import ru.trimok.films.domain.models.MovieShort
import ru.trimok.films.presentation.details_activity.DetailsActivity

class MoviesAdapter(private val context: Context) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private val moviesMutableList = mutableListOf<MovieShort>()

    inner class MoviesViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = FilmsListItemBinding.bind(item)

        fun bind(movie: MovieShort) = with(binding) {
            Picasso.get().load(movie.posterUrlPreview).into(movieLogoImageView)
            movieNameTextView.text = movie.nameRu
            var genres = ""
            for (genre in movie.genres)
                genres += " $genre"
            movieGenreTextView.text = String.format(context.getString(R.string.genre_movie), genres)
            movieReleaseDateTextView.text =
                String.format(context.getString(R.string.release_year_movie), movie.year)
            filmRatingTextView.text = movie.rating
            filmRatingBar.rating = movie.rating?.toFloat()!!

            movieCardView.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("movieId", movie.filmId.toString())
                context.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.films_list_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesMutableList[position])
    }

    override fun getItemCount(): Int {
        return moviesMutableList.size
    }

    fun addItems(moviesMutableList: MutableList<MovieShort>) {
        val rangeMin = this.moviesMutableList.size
        val rangeMax = moviesMutableList.size
        this.moviesMutableList.addAll(moviesMutableList)
        notifyItemRangeChanged(rangeMin, rangeMin + rangeMax - 1)
    }
}