package com.example.kotlin_android_user.company.activities

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin_android_user.company.viewmodels.CompanyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CompaniesActivity:AppCompatActivity(){
    private val companyViewModel: CompanyViewModel by viewModels()

}