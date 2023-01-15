package com.example.kotlin_android_user.company.apiservices

import com.example.kotlin_android_user.company.models.Company
import com.example.kotlin_android_user.config.Config
import retrofit2.http.GET
import retrofit2.http.Path

interface CompanyApiService {
    @GET(Config.company_url + "/{id}")
   suspend fun load(@Path("id") companyId: String): Company
}