package com.abbc.mymoviebookingapp.network.responses.movie.snack

import com.google.gson.annotations.SerializedName
import com.abbc.mymoviebookingapp.data.vos.movie.snack.SnackCategoryVO

data class SnackCategoryResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<SnackCategoryVO>?
)
