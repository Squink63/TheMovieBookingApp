package com.abbc.mymoviebookingapp.network.responses.movie

import com.google.gson.annotations.SerializedName
import com.abbc.mymoviebookingapp.data.vos.movie.BannerVO

data class BannerResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<BannerVO>?
)