package com.abbc.mymoviebookingapp.ui.viewholders.movie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abbc.mymoviebookingapp.data.vos.movie.snack.SnackVO
import com.abbc.mymoviebookingapp.databinding.ViewHolderSnackCheckoutBinding

class SnackCheckoutViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    private var binding: ViewHolderSnackCheckoutBinding

    init {
        binding = ViewHolderSnackCheckoutBinding.bind(itemView)
    }

    fun bindData(snack: SnackVO) {
        binding.tvFoodName.text = snack.name
        binding.tvQty.text = snack.quantity.toString()
        binding.tvFoodPrice.text = snack.price.toString()
    }
}