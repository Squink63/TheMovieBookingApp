package com.abbc.mymoviebookingapp.network.responses.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.abbc.mymoviebookingapp.data.vos.login.OtpVO
import com.abbc.mymoviebookingapp.persistance.typeconverter.OtpTypeConverter

@Entity("OTP")
@TypeConverters(
    OtpTypeConverter::class
)
data class OtpResponse(
    @SerializedName("code")
    @PrimaryKey
    val code: Int?,

    @SerializedName("message")
    @ColumnInfo("message")
    val message: String?,

    @SerializedName("data")
    @ColumnInfo("data")
    val data: OtpVO?,

    @SerializedName("token")
    @ColumnInfo("token")
    val token: String?
)
