package com.abbc.mymoviebookingapp.network

import com.abbc.mymoviebookingapp.data.vos.movie.checkout.CheckoutBody
import com.abbc.mymoviebookingapp.network.responses.*
import com.abbc.mymoviebookingapp.network.responses.cinema.CinemaInfoResponse
import com.abbc.mymoviebookingapp.network.responses.login.CitiesResponse
import com.abbc.mymoviebookingapp.network.responses.login.OtpResponse
import com.abbc.mymoviebookingapp.network.responses.movie.*
import com.abbc.mymoviebookingapp.network.responses.movie.cinema.CinemaConfigResponse
import com.abbc.mymoviebookingapp.network.responses.movie.cinema.CinemaTimeslotResponse
import com.abbc.mymoviebookingapp.network.responses.movie.snack.SnackCategoryResponse
import com.abbc.mymoviebookingapp.network.responses.movie.snack.SnackListResponse
import com.abbc.mymoviebookingapp.network.responses.profile.LogoutResponse
import com.abbc.mymoviebookingapp.network.utiles.*
import retrofit2.Call
import retrofit2.http.*

interface TheMovieBookingApi {

    @FormUrlEncoded
    @POST(API_POST_OTP)
    fun getOTP(@Field(FIELD_PHONE) phone: String): Call<OtpResponse>

    @FormUrlEncoded
    @POST(API_POST_SIGN_IN_WITH_PHONE)
    fun checkOTP(
        @Field(FIELD_PHONE) phone: String,
        @Field(FIELD_OTP) otp: String
    ): Call<OtpResponse>

    @GET(API_GET_CITIES)
    fun getCities(): Call<CitiesResponse>

    @GET(API_GET_BANNER)
    fun getBanner(): Call<BannerResponse>

    @GET(API_GET_NOW_PLAYING)
    fun getNowPlayingMovies(
        @Query(PARAM_STATUS) status: String = MOVIE_API_NOW_PLAYING_KEY
    ): Call<MovieListResponse>

    @GET(API_GET_COMING_SOON)
    fun getComingSoonMovies(
        @Query(PARAM_STATUS) status: String = MOVIE_API_COMING_SOON_KEY
    ): Call<MovieListResponse>

    @GET("$API_GET_MOVIE_DETAIL/{movie_id}")
    fun getMovieDetailById(
        @Path("movie_id") movieId: String
    ): Call<MovieDetailResponse>

    @GET(API_GET_CINEMA_TIMESLOTS)
    fun getCinemaTimeslot(
        @Header(AUTHORIZATION) authorization: String,
        @Query(PARAM_DATE) date: String
    ): Call<CinemaTimeslotResponse>

    @GET(API_GET_CINEMA_CONFIG)
    fun getCinemaConfig(): Call<CinemaConfigResponse>

    // Cinema Info Screen
    @GET(API_GET_CINEMA_INFO)
    fun getCinemaInfo(
        @Query(PARAM_LATEST_TIME) latestTime:String = "2022-09-17 00:23:04"
    ) : Call<CinemaInfoResponse>

    @GET(API_GET_SEATING_PLAN)
    fun getSeatingPlan(
        @Header(AUTHORIZATION) authorization: String,
        @Query(PARAM_CINEMA_DAY_TIMESLOT_ID) timeslotId: Int,
        @Query(PARAM_BOOKING_DATE) bookingDate: String
    ): Call<SeatListResponse>

    @GET(API_GET_SNACK_CATEGORY)
    fun getSnackCategory(
        @Header(AUTHORIZATION) authorization: String,
    ): Call<SnackCategoryResponse>

    @GET(API_GET_SNACK)
    fun getSnackByCategoryId(
        @Header(AUTHORIZATION) authorization: String,
        @Query(PARAM_SNACK_CATEGORY) categoryId: String
    ): Call<SnackListResponse>

    @GET(API_GET_PAYMENT)
    fun getPaymentType(
        @Header(AUTHORIZATION) authorization: String
    ): Call<PaymentListResponse>

    @POST(API_POST_CHECK_OUT)
    fun getCheckoutTicket(
        @Header(AUTHORIZATION) authorization: String,
        @Body checkoutTicket: CheckoutBody
    ): Call<CheckoutResponse>

    @POST(API_POST_LOG_OUT)
    fun logout(
        @Header(AUTHORIZATION) authorization: String
    ): Call<LogoutResponse>

}