package com.example.kotlin_android_user.company.repositories.impl

import androidx.lifecycle.MutableLiveData
import com.example.kotlin_android_user.company.localdatasources.CompanyLocalDatasource
import com.example.kotlin_android_user.company.models.Company
import com.example.kotlin_android_user.company.remotedatasources.CompanyRemoteDatasource
import com.example.kotlin_android_user.company.repositories.CompanyRepository
import javax.inject.Inject

class CompanyRepositoryImpl @Inject constructor(private val remoteDatasource: CompanyRemoteDatasource, private val localDatasource: CompanyLocalDatasource):
    CompanyRepository {
    override suspend fun load(id: String) = remoteDatasource.load(id)
}