package com.example.kotlin_android_user.company.repositories

import androidx.lifecycle.MutableLiveData
import com.example.kotlin_android_user.company.models.Company

interface CompanyRepository {
    suspend fun load(id: String): Company

}