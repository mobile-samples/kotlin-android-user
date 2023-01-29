package com.example.kotlin_android_user.company.repositories

import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.commons.models.SearchResult

interface CompanyRateRepository {
    suspend fun search(): SearchResult<Rates>?;
    suspend fun rate(id:String, author:String, obj:Rates):Int?
}