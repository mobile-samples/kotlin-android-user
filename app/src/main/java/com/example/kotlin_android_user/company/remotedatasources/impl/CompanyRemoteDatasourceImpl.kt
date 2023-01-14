package com.example.kotlin_android_user.company.remotedatasources.impl

import com.example.kotlin_android_user.apiservices.CompanyApiService
import com.example.kotlin_android_user.company.models.Company
import com.example.kotlin_android_user.company.remotedatasources.CompanyRemoteDatasource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class CompanyRemoteDatasourceImpl @Inject constructor(apiService: CompanyApiService) :
    CompanyRemoteDatasource {
    private val apiService: CompanyApiService

    init {
        this.apiService = apiService
    }

    override suspend fun load(id: String) = apiService.load(id);

}