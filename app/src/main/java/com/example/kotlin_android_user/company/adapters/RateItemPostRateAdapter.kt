package com.example.kotlin_android_user.company.adapters;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_android_user.commons.models.RateCriteriaItem
import com.example.kotlin_android_user.databinding.RowPostRateBinding

open class RateItemPostRateAdapter(private val localDataSet:List<RateCriteriaItem>)
    :RecyclerView.Adapter<RateItemPostRateAdapter.ViewHolder>(){

    class ViewHolder(binding: RowPostRateBinding): RecyclerView.ViewHolder(binding.root) {
        val binding: RowPostRateBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view:RowPostRateBinding = RowPostRateBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.rbRate.setOnRatingBarChangeListener { _, rating, _ ->
            localDataSet[position].score = rating
        }
        holder.binding.tvRateType.text = localDataSet[position].rateType;
        holder.binding.rbRate.rating = localDataSet[position].score?:0.0f;
    }

    override fun getItemCount(): Int {
        return localDataSet.size
    }
}
