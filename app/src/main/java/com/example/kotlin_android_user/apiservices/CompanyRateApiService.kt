package com.example.kotlin_android_user.apiservices

import com.example.kotlin_android_user.commons.models.Rates
import com.example.kotlin_android_user.commons.models.SearchResult
import com.example.kotlin_android_user.config.Config
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.POST

interface CompanyRateApiService {
    @GET(Config.company_rate_url + "/search")
    suspend fun search(): SearchResult<Rates>?

    @POST(Config.company_rate_url + "/{id}/{author}")
    suspend fun rate(obj: Rates): Int?
}
