package ru.trimok.films.main_activity.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.trimok.films.R
import ru.trimok.films.databinding.FilmsListItemBinding
import ru.trimok.films.main_activity.domain.models.Movie
import ru.trimok.films.main_activity.presentation.MainViewModel

class MoviesAdapter(private val mainViewModel: MainViewModel, private val context: Context): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private val moviesMutableList = mutableListOf<Movie>()

    inner class MoviesViewHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = FilmsListItemBinding.bind(item)

        fun bind(movie: Movie) = with(binding){
            Picasso.get().load(movie.posterUrlPreview).into(movieLogoImageView)
            movieNameTextView.text = movie.nameRu
            var genres = ""
            for(genre in movie.genres)
                genres += " $genre"
            movieGenreTextView.text = String.format(context.getString(R.string.genre_movie), genres)
            movieReleaseDateTextView.text = String.format(context.getString(R.string.release_year_movie), movie.year)
            filmRatingTextView.text = movie.rating
            filmRatingBar.rating = movie.rating?.toFloat()!!

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.films_list_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesMutableList[position])
    }

    override fun getItemCount(): Int {
        return moviesMutableList.size
    }

    fun addItems(moviesMutableList: MutableList<Movie>){
        val rangeMin = this.moviesMutableList.size
        val rangeMax = moviesMutableList.size
        this.moviesMutableList.addAll(moviesMutableList)
        notifyItemRangeChanged(rangeMin, rangeMin + rangeMax - 1)
    }
}