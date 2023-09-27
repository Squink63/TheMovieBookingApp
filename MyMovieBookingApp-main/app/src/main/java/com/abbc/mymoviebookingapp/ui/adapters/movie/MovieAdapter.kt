package com.abbc.mymoviebookingapp.ui.adapters.movie

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.abbc.mymoviebookingapp.R
import com.abbc.mymoviebookingapp.data.vos.movie.MovieVO
import com.abbc.mymoviebookingapp.ui.delgates.MovieViewHolderDelegate
import com.abbc.mymoviebookingapp.ui.viewholders.movie.MovieViewHolder

class MovieAdapter(
    private val isComingSoon: Boolean,
    private val delegate: MovieViewHolderDelegate
):RecyclerView.Adapter<MovieViewHolder>() {

    private var mMovieList: List<MovieVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie,parent,false)
        return MovieViewHolder(view.rootView,delegate)
    }

    override fun getItemCount(): Int {
        return mMovieList.count()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.findViewById<FrameLayout>(R.id.flReleaseDate).visibility = if(isComingSoon) View.VISIBLE else View.GONE
        if (mMovieList.isNotEmpty()){
            holder.bindData(mMovieList[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(movieList: List<MovieVO>){
        mMovieList = movieList
        notifyDataSetChanged()
    }
}