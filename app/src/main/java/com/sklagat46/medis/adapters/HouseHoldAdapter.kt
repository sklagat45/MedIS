package com.sklagat46.medis.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.sklagat46.medis.R
import com.sklagat46.medis.model.DataHolder
import com.sklagat46.medis.views.HouseHoldViewHolder

class HouseHoldAdapter(options: FirebaseRecyclerOptions<DataHolder>) : FirebaseRecyclerAdapter<DataHolder, HouseHoldViewHolder>(
    options
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseHoldViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_recycler_data_columns, parent, false)
        return HouseHoldViewHolder(view)
    }

    override fun onBindViewHolder(holder: HouseHoldViewHolder, position: Int, model: DataHolder) {

        holder.mHouseHeadName?.text = model.getHouseheadName()
        holder.mStatus?.text = model.getstatus()
        holder.mDateofData?.text = model.getDateData()
//        model.getHouseheadName()?.let { model.setHouseHeadName()
//
//        };
    }
}