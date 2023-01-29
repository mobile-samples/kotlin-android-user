package com.example.kotlin_android_user.company.repositories.impl;

import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.commons.models.SearchResult
import com.example.kotlin_android_user.company.localdatasources.CompanyRateLocalDatasource
import com.example.kotlin_android_user.company.remotedatasources.CompanyRateRemoteDatasource
import com.example.kotlin_android_user.company.repositories.CompanyRateRepository
import javax.inject.Inject

class CompanyRateRepositoryImpl @Inject constructor(val companyRateRemoteDatasource: CompanyRateRemoteDatasource, val companyLocalRateDatasource: CompanyRateLocalDatasource):CompanyRateRepository{
    override suspend fun search(): SearchResult<Rates>? {
        return companyRateRemoteDatasource.search();
    }

    override suspend fun rate(id: String, author: String, obj: Rates): Int? {
        return companyRateRemoteDatasource.rate(id,author,obj);
    }
}
