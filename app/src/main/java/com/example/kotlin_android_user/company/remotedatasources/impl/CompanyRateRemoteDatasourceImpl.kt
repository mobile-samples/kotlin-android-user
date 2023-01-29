package com.example.kotlin_android_user.company.remotedatasources.impl;

import com.example.kotlin_android_user.company.apiservices.CompanyRateApiService
import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.commons.models.SearchResult
import com.example.kotlin_android_user.company.remotedatasources.CompanyRateRemoteDatasource
import javax.inject.Inject

class CompanyRateRemoteDatasourceImpl
@Inject constructor(private val apiService: CompanyRateApiService):CompanyRateRemoteDatasource{
    override suspend fun search(): SearchResult<Rates>? = apiService.search()


    override suspend fun rate(id: String, author: String, rates: Rates): Int? {
        return apiService.rate(id,author,rates);
    }

}
