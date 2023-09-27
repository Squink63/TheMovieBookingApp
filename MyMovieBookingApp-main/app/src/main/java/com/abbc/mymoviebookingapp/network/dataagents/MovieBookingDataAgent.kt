package com.abbc.mymoviebookingapp.network.dataagents

import com.abbc.mymoviebookingapp.data.vos.cinema.CinemaInfoVO
import com.abbc.mymoviebookingapp.data.vos.login.CitiesVO
import com.abbc.mymoviebookingapp.data.vos.movie.BannerVO
import com.abbc.mymoviebookingapp.data.vos.movie.MovieVO
import com.abbc.mymoviebookingapp.data.vos.movie.PaymentVO
import com.abbc.mymoviebookingapp.data.vos.movie.SeatVO
import com.abbc.mymoviebookingapp.data.vos.movie.checkout.CheckoutBody
import com.abbc.mymoviebookingapp.data.vos.movie.checkout.CheckoutVO
import com.abbc.mymoviebookingapp.data.vos.movie.cinema_showtime.CinemaConfigVO
import com.abbc.mymoviebookingapp.data.vos.movie.cinema_showtime.CinemaVO
import com.abbc.mymoviebookingapp.data.vos.movie.snack.SnackCategoryVO
import com.abbc.mymoviebookingapp.data.vos.movie.snack.SnackVO
import com.abbc.mymoviebookingapp.network.responses.login.OtpResponse
import com.abbc.mymoviebookingapp.network.responses.profile.LogoutResponse

interface MovieBookingDataAgent {

    // login
    fun getOTP(
        phone: String,
        onSuccess: (OtpResponse) -> Unit,
        onFailure: (String) -> Unit
    )

    fun checkOTP(
        phone: String,
        otp: String,
        onSuccess: (OtpResponse) -> Unit,
        onFailure: (String) -> Unit
    )

    // cities
    fun getCities(
        onSuccess: (List<CitiesVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // banner
    fun getBanner(
        onSuccess: (List<BannerVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // movie
    fun getNowPlayingMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getComingSoonMovies(
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // movie detail
    fun getMovieDetailById(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    // cinema datetime
    fun getCinemaAndTimeslot(
        authorization: String,
        date: String,
        onSuccess: (List<CinemaVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getCinemaConfig(
        onSuccess: (List<CinemaConfigVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    // cinema info
    fun getCinemaInfo(
        onSuccess:(List<CinemaInfoVO>) -> Unit,
        onFailure:(String) -> Unit
    )

    fun getSeatingPlan(
        authorization: String,
        timeslotId: Int,
        bookingDate: String,
        onSuccess: (MutableList<MutableList<SeatVO>>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSnackCategory(
        authorization: String,
        onSuccess: (List<SnackCategoryVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSnackByCategoryId(
        authorization: String,
        categoryId: String,
        onSuccess: (List<SnackVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPaymentType(
        authorization: String,
        onSuccess: (List<PaymentVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getCheckoutTicket(
        authorization: String,
        checkoutTicket: CheckoutBody,
        onSuccess: (CheckoutVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun logout(
        authorization: String,
        onSuccess: (LogoutResponse) -> Unit,
        onFailure: (String) -> Unit
    )

}