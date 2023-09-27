package com.abbc.mymoviebookingapp.ui.viewholders.movie

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.abbc.mymoviebookingapp.data.vos.movie.BannerVO
import com.abbc.mymoviebookingapp.databinding.ViewHolderBannerBinding

class BannerViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    private var binding: ViewHolderBannerBinding

    init {
        binding = ViewHolderBannerBinding.bind(itemView)
    }

    fun bindData(banner: BannerVO) {
        Log.d("BannerViewHolder","bannerImage: ${banner.url}")
        Glide.with(itemView.context)
            .load("${banner.url}")
            .into(binding.ivBanner)
    }

}