package com.example.kotlin_android_user.company.remotedatasources

import com.example.kotlin_android_user.company.models.Company
import io.reactivex.rxjava3.core.Observable

interface CompanyRemoteDatasource {
    suspend fun load(id: String): Company
}