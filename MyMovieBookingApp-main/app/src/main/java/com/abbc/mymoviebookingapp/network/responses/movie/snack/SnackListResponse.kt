package com.abbc.mymoviebookingapp.network.responses.movie.snack

import com.google.gson.annotations.SerializedName
import com.abbc.mymoviebookingapp.data.vos.movie.snack.SnackVO

data class SnackListResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<SnackVO>?
)
