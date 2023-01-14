package com.example.kotlin_android_user.company.fragments

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.kotlin_android_user.commons.di.DaggerAppComponent
import com.example.kotlin_android_user.commons.models.RateCriteriaItem
import com.example.kotlin_android_user.company.adapters.RateInfoSumAdapter
import com.example.kotlin_android_user.company.adapters.ReviewAdapter
import com.example.kotlin_android_user.company.viewmodels.CompanyRateViewModel
import com.example.kotlin_android_user.company.viewmodels.CompanyViewModel
import com.example.kotlin_android_user.databinding.FragmentReviewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class ReviewFragment : Fragment() {
    private lateinit var binding: FragmentReviewBinding
//    @Inject
    private val companyViewModel: CompanyViewModel by viewModels()
//    @Inject
    private val companyRateViewModel: CompanyRateViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        companyViewModel.company.observe(viewLifecycleOwner) {
            it.info.let {it1->
                run {
                    if (it1 != null) {
                        Log.d(TAG,companyViewModel.company.value.toString())

                        val localDataSet = listOf(
                            RateCriteriaItem(it1.rate1, "Job Work/Life Balance"),
                            RateCriteriaItem(it1.rate2, "Compensation/Benefits"),
                            RateCriteriaItem(it1.rate3, "Job Security/Advancement"),
                            RateCriteriaItem(it1.rate4, "Management"),
                            RateCriteriaItem(it1.rate5, "Culture")
                        )
                        binding.rvRatesSummary.layoutManager = LinearLayoutManager(context)
                        binding.rvRatesSummary.adapter =  RateInfoSumAdapter(localDataSet)
                        val score = (it1.rate.times(100.0)).roundToInt().toFloat()
                        binding.tvSumScore.text = score.toString();
                        binding.rbRateSummary.rating = score;
                    }
                }
            }
        }
        companyRateViewModel.search().observe(viewLifecycleOwner){it.let{
            if(it.data!=null){
                companyRateViewModel.setSearchResult(it.data);
            }
        }}
        companyRateViewModel.searchResult.observe(viewLifecycleOwner){
            it.let {
                if (it != null) {
                    binding.rvRateList.adapter = ReviewAdapter(it.list)
                    binding.rvRateList.layoutManager = LinearLayoutManager(context)
                };
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReviewBinding.inflate(inflater,container,false);
        return binding.root;
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (context.applicationContext as App).appComponent.inject(this)
//    }
}