package com.example.kotlin_android_user.company.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.databinding.RowRateitemBinding
import java.text.SimpleDateFormat

class ReviewAdapter(localDataSet: List<Rates>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    private val localDataSet: List<Rates>

    init {
        this.localDataSet = localDataSet
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view: RowRateitemBinding =
            RowRateitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val item: Rates = localDataSet[position]

        holder.binding.tvRateItemScore.text= item.rate.toString()
        holder.binding.tvUsername.text = item.author
        holder.binding.tvComment.text = item.review

        val format = SimpleDateFormat("dd/MM/yyyy")
        holder.binding.tvDatetime.text = format.format(item.time!!.time)
    }

    override fun getItemCount(): Int {
        return localDataSet.size
    }

    class ReviewViewHolder( binding: RowRateitemBinding) : RecyclerView.ViewHolder(binding.root){
        val binding: RowRateitemBinding
        init {
            this.binding = binding
        }
    }

}
