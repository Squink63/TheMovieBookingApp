package com.abbc.mymoviebookingapp.ui.delgates

interface SeatViewHolderDelegate {
    fun onTapSeat(seatName: String,seatPrice: Int ,isAvailable:Boolean?)
}