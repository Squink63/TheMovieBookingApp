package com.abbc.mymoviebookingapp.ui.adapters.login

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abbc.mymoviebookingapp.R
import com.abbc.mymoviebookingapp.data.vos.login.CitiesVO
import com.abbc.mymoviebookingapp.ui.delgates.RegionViewHolderDelegate
import com.abbc.mymoviebookingapp.ui.viewholders.login.RegionViewHolder

class RegionAdapter(
    private val citiesList: List<CitiesVO>,
    private val delegate: RegionViewHolderDelegate,
):RecyclerView.Adapter<RegionViewHolder>() {

    private var mCitiesList: List<CitiesVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_region,parent,false)
        return RegionViewHolder(view.rootView,delegate)
    }

    override fun getItemCount(): Int {
        return citiesList.count()
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        if (citiesList.isNotEmpty()){
            holder.bindData(citiesList[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(cities: List<CitiesVO>) {
        mCitiesList = cities
        notifyDataSetChanged()
    }
}