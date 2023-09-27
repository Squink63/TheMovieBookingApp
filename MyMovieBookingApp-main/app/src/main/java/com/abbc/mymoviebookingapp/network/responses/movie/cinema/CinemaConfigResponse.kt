package com.abbc.mymoviebookingapp.network.responses.movie.cinema

import com.google.gson.annotations.SerializedName
import com.abbc.mymoviebookingapp.data.vos.movie.cinema_showtime.CinemaConfigVO

data class CinemaConfigResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<CinemaConfigVO>?
)
