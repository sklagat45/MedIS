package com.sklagat46.medis.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sklagat46.medis.R
import com.sklagat46.medis.model.IndividualData
import com.sklagat46.medis.ui.interfaces.IItemClickListener


class IndividualItemAdapter(private val context: Context,
    private val individualDataList: List<IndividualData>?
): RecyclerView.Adapter<IndividualItemAdapter.IndividualDataViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IndividualItemAdapter.IndividualDataViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.custom_individual_data_columns,
            parent,
            false
        )

        return IndividualDataViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: IndividualItemAdapter.IndividualDataViewHolder,
        position: Int
    ) {
        holder.mname_hhh_column.text = individualDataList!![position].individualName!!
        holder.mrelation_column.text = individualDataList!![position].relation!!
        holder.mindividual_status_column.text = individualDataList!![position].status!!

    }

    override fun getItemCount(): Int {
        return individualDataList?.size ?:0    }


    inner class IndividualDataViewHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener {

        var mname_hhh_column: TextView = view.findViewById(R.id.name_hhh_column) as TextView
        var mrelation_column: TextView = view.findViewById(R.id.relation_column) as TextView
        var mindividual_status_column: TextView = view.findViewById(R.id.individual_status_column) as TextView

        lateinit var iItemClickListener: IItemClickListener
        fun setClick(iItemClickListener: IItemClickListener) {
            this.iItemClickListener = iItemClickListener
        }

        init{

            view.setOnClickListener(this)
        }
        override fun onClick(view: View?) {

            iItemClickListener.onItemClickListener(view!!, adapterPosition)
        }

    }
}