package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab2.databinding.ItemFilmLayoutBinding

class FilmAdapter(val launchFragment: (FilmModel)->Unit): RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    val filmList = ArrayList<FilmModel>()

    inner class FilmViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        private val binding = ItemFilmLayoutBinding.bind(itemView)
        fun bindFun(film: FilmModel)
        {
            binding.card.setOnClickListener{
                launchFragment(filmList[adapterPosition])
            }
            Glide.with(binding.ivItemFilm.context).load(film.image).into(binding.ivItemFilm)

            binding.tvFilm.text=film.name
            binding.tvYear.text=film.year.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film_layout,parent, false)
        return FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int)
    {
        holder.bindFun(filmList[position])
    }

    override fun getItemCount(): Int
    {
        return filmList.size
    }

    fun addFilm(filmSet: List<FilmModel>)
    {
        filmList.addAll(filmSet)
        notifyDataSetChanged()
    }
}