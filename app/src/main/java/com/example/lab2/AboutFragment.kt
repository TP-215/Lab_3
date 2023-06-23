package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.lab2.databinding.FragmentAboutBinding

class AboutFragment : Fragment(R.layout.fragment_about) {

    private val args: AboutFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val film = args.filmModel
        val binding = FragmentAboutBinding.bind(view)
        binding.tvFilmLabel.text = film.name
        binding.tvAboutYear.text = film.year.toString()
        binding.tvFilmAbout.text = film.about
        Glide.with(binding.ivFilmImage.context).load(film.image).into(binding.ivFilmImage)

        binding.btnBack.setOnClickListener{findNavController().popBackStack()}
    }
}