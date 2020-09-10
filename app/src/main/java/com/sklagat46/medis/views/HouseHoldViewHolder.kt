package com.sklagat46.medis.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sklagat46.medis.R


public class HouseHoldViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mHouseHeadName: TextView? = itemView?.findViewById(R.id.tv_name_column);
    var mStatus: TextView? = itemView?.findViewById(R.id.tv_status_column);
    var mDateofData: TextView? =itemView?.findViewById(R.id.tv_date_column);


//    public fun houseHoldViewHolder(itemView: View){
//        mHouseHeadName =  itemView?.findViewById(R.id.tv_name_column);
//        mStatus = itemView?.findViewById(R.id.tv_status_column);
//        mDateofData = itemView?.findViewById(R.id.tv_date_column);
//
//    }

}