package com.example.kotlin_android_user.company.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin_android_user.company.fragments.AboutFragment
import com.example.kotlin_android_user.company.activities.CompaniesActivity
import com.example.kotlin_android_user.company.fragments.CompanyFragment
import com.example.kotlin_android_user.company.fragments.OverviewFragment
import com.example.kotlin_android_user.company.fragments.ReviewFragment
import com.example.kotlin_android_user.company.viewmodels.CompanyViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

class CompanyViewPagerAdapter constructor(private val companyFragment: CompanyFragment):FragmentStateAdapter(companyFragment) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OverviewFragment()
            2 -> AboutFragment()
            else -> ReviewFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}