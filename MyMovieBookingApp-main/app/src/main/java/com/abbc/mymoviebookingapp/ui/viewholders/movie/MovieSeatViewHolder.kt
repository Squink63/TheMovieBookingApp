package com.abbc.mymoviebookingapp.ui.viewholders.movie

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.abbc.mymoviebookingapp.R
import com.abbc.mymoviebookingapp.data.vos.movie.SeatVO
import com.abbc.mymoviebookingapp.databinding.ViewHolderMovieSeatBinding
import com.abbc.mymoviebookingapp.ui.delgates.SeatViewHolderDelegate

class MovieSeatViewHolder(itemView: View, delegate: SeatViewHolderDelegate) :RecyclerView.ViewHolder(itemView) {

    private var binding: ViewHolderMovieSeatBinding
    private val numberOfColumn = 18
    private var mSeatVO:SeatVO? = null

    init {
        binding = ViewHolderMovieSeatBinding.bind(itemView)
        binding.ivSeat.setOnClickListener {
            if (mSeatVO?.selectedSeat == false){
                delegate.onTapSeat(mSeatVO?.seatName ?: "", (mSeatVO?.price ?: "") as Int, mSeatVO?.selectedSeat)
            }else{
                delegate.onTapSeat(mSeatVO?.seatName ?: "", (mSeatVO?.price ?: "") as Int, mSeatVO?.selectedSeat)
            }
        }
    }

    fun bindSeatData(seatList: MutableList<MutableList<SeatVO>>, position: Int) {

        val row = position / numberOfColumn
        val col = position % numberOfColumn
        val seat = seatList[row][col]

        mSeatVO = seat

        if (mSeatVO?.selectedSeat == true){
            binding.ivSeat.setColorFilter(ContextCompat.getColor(itemView.context, R.color.green),android.graphics.PorterDuff.Mode.MULTIPLY)
        }else{
            binding.ivSeat.setColorFilter(ContextCompat.getColor(itemView.context, R.color.white),android.graphics.PorterDuff.Mode.MULTIPLY)
        }



        when(seat.type){
            "text" -> {
                binding.tvSeatType.visibility = View.VISIBLE
                binding.ivSeat.visibility = View.INVISIBLE
                binding.tvSeatType.text = seat.symbol
            }
            "space","path" -> {
                binding.tvSeatType.visibility = View.INVISIBLE
                binding.ivSeat.visibility = View.INVISIBLE
            }
            "taken" -> {
                binding.tvSeatType.visibility = View.INVISIBLE
                binding.ivSeat.visibility = View.VISIBLE
                binding.ivSeat.setColorFilter(ContextCompat.getColor(itemView.context, R.color.textSecondary),android.graphics.PorterDuff.Mode.MULTIPLY)
            }
            "available" -> {
                binding.tvSeatType.visibility = View.INVISIBLE
                binding.ivSeat.visibility = View.VISIBLE
            }
        }
    }

}