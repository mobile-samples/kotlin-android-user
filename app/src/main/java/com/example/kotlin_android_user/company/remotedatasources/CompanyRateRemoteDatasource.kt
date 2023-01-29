package com.example.kotlin_android_user.company.remotedatasources

import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.commons.models.SearchResult
import io.reactivex.rxjava3.core.Observable

interface CompanyRateRemoteDatasource {
    suspend fun search(): SearchResult<Rates>?
    suspend fun rate(id:String,author:String,rates: Rates): Int?
}