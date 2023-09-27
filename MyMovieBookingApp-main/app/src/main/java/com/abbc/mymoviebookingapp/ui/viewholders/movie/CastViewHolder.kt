package com.abbc.mymoviebookingapp.ui.viewholders.movie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.abbc.mymoviebookingapp.data.vos.movie.CastVO
import com.abbc.mymoviebookingapp.databinding.ViewHolderCastBinding
import com.abbc.mymoviebookingapp.network.utiles.IMAGE_BASE_URL

class CastViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    private var binding: ViewHolderCastBinding

    init {
        binding = ViewHolderCastBinding.bind(itemView)
    }

    fun bindData(cast: CastVO) {
        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${cast.profilePath}")
            .into(binding.ivCast)

        binding.tvCastName.text = cast.name
    }
}