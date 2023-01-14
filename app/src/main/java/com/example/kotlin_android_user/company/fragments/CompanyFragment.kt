package com.example.kotlin_android_user.company.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.kotlin_android_user.R
import com.example.kotlin_android_user.commons.models.Status
import com.example.kotlin_android_user.company.adapters.CompanyViewPagerAdapter
import com.example.kotlin_android_user.company.viewmodels.CompanyViewModel
import com.example.kotlin_android_user.databinding.FragmentCompanyBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompanyFragment : Fragment(R.layout.fragment_company) {
    private val companyViewModel: CompanyViewModel by viewModels()

    private lateinit var binding:FragmentCompanyBinding
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (context.applicationContext as App).appComponent.inject(this)
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_company, container, false)
        binding.companyViewModel = companyViewModel;
        binding.lifecycleOwner = this
        getCompanyById("id1")
        binding.menuPager.adapter= CompanyViewPagerAdapter(this)
        TabLayoutMediator(
            binding.menuTab, binding.menuPager
        ) { tab: TabLayout.Tab, position: Int ->
            when (position) {
                0 -> tab.text = "Overview"
                1 -> tab.text = getString(R.string.review)
                2 -> tab.text = getString(R.string.about)
                else -> {}
            }
        }.attach()
        return binding.root
    }


    private fun getCompanyById(id: String) {

        companyViewModel.load(id).observe(viewLifecycleOwner) {
            it.let { resource ->

                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data.let { company ->
                            if (company != null) {
                                companyViewModel.setCompany(company)
                                companyViewModel.company.value
                                Glide.with(binding.imgAvatar).load(company.imageURL)
                                    .into(binding.imgAvatar)
                                Glide.with(binding.imgCoverURL).load(company.coverURL)
                                    .into(binding.imgCoverURL)
                            }
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(requireContext(), it.messages, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {

                    }
                }

            }
        }
    }

}