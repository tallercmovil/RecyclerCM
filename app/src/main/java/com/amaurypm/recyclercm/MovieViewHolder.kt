package com.amaurypm.recyclercm

import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.recyclercm.databinding.MovieItemBinding
import com.amaurypm.recyclercm.model.Movie
import kotlinx.coroutines.flow.combine

class MovieViewHolder(
    private val binding: MovieItemBinding
): RecyclerView.ViewHolder(binding.root) {

    //Implementamos un método para vincular las vistas
    fun bind(movie: Movie){
        binding.apply {
            tvTitle.text = movie.title
            tvType.text = movie.type
            tvDate.text = movie.date
        }
    }

}