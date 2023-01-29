package com.example.kotlin_android_user.company.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_android_user.commons.models.RateCriteriaItem
import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.commons.models.ShortRate
import com.example.kotlin_android_user.commons.models.Status
import com.example.kotlin_android_user.company.adapters.RateItemPostRateAdapter
import com.example.kotlin_android_user.company.viewmodels.CompanyRateViewModel
import com.example.kotlin_android_user.databinding.FragmentPostRatesBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.stream.Collectors

@AndroidEntryPoint
class PostRateDialogFragment(val id: String, val author: String, val name:String) : DialogFragment() {
    private val companyViewModel: CompanyRateViewModel by activityViewModels()
    private lateinit var binding: FragmentPostRatesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvName.text=name
        binding.rvRateItemPostRate.layoutManager = LinearLayoutManager(context)
        val dataSet = listOf(
            RateCriteriaItem(0.0f, "Job Work/Life Balance"),
            RateCriteriaItem(0.0f, "Compensation/Benefits"),
            RateCriteriaItem(0.0f, "Job Security/Advancement"),
            RateCriteriaItem(0.0f, "Management"),
            RateCriteriaItem(0.0f, "Culture")
        )
        binding.rvRateItemPostRate.adapter = RateItemPostRateAdapter(dataSet)

        binding.lifecycleOwner = this
        binding.btnClose.setOnClickListener {
            dismiss()
        }
        binding.btnSave.setOnClickListener {
            var rateList = mutableListOf<Float>()
            for (item in dataSet) {
                rateList.add(item.score)
            }
            val rates = Rates(this.id,this.author,null, rateList, null,
                binding.edtReview.text.toString(), 0, 0, listOf<ShortRate>())
            companyViewModel.rate(id, author, rates).observe(viewLifecycleOwner){
                it.let{
                    resource ->
                    when(resource.status){
                        Status.SUCCESS->{
                            dismiss()
                        }
                        Status.ERROR->{
                            Toast.makeText(requireContext(),it.messages, Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING->{

                        }
                    }
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostRatesBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "PostRateDialogFragment"
    }

    override fun onResume() {
        super.onResume()
        val params = dialog?.window?.attributes
        if (params != null) {
            params.width = LayoutParams.MATCH_PARENT
            params.height = LayoutParams.WRAP_CONTENT
            dialog!!.window!!.attributes = params

        }
    }
}
