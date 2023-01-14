package com.example.kotlin_android_user.company.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_android_user.commons.models.RateCriteriaItem
import com.example.kotlin_android_user.databinding.RowRatecriteriaBinding


class RateInfoSumAdapter(localDataSet: List<RateCriteriaItem>) :
    RecyclerView.Adapter<RateInfoSumAdapter.ViewHolder>() {
    private val localDataSet: List<RateCriteriaItem>

    init {
        this.localDataSet = localDataSet
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: RowRatecriteriaBinding =
            RowRatecriteriaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvRateType.text = localDataSet[position].rateType
        holder.binding.tvScore.text = localDataSet[position].score.toString()
    }

    override fun getItemCount(): Int {
        return localDataSet.size
    }

    class ViewHolder(binding: RowRatecriteriaBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding: RowRatecriteriaBinding

        init {
            this.binding = binding
        }
    }
}