package com.abbc.mymoviebookingapp.network.responses.movie

import com.google.gson.annotations.SerializedName
import com.abbc.mymoviebookingapp.data.vos.movie.PaymentVO

data class PaymentListResponse(
    @SerializedName("code")
    val code: Int?,

    @SerializedName("message")
    val message: String?,

    @SerializedName("data")
    val data: List<PaymentVO>?,
)
