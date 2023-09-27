package com.abbc.mymoviebookingapp.ui

import android.app.Application
import com.abbc.mymoviebookingapp.data.models.MovieBookingModelImpl

class MovieBookingApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MovieBookingModelImpl.initMovieBookingDatabase(applicationContext)
    }
}