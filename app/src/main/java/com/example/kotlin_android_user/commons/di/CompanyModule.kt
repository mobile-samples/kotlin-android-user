package com.example.kotlin_android_user.commons.di

import com.example.kotlin_android_user.company.localdatasources.CompanyLocalDatasource
import com.example.kotlin_android_user.company.localdatasources.CompanyRateLocalDatasource
import com.example.kotlin_android_user.company.localdatasources.impl.CompanyLocalDatasourceImpl
import com.example.kotlin_android_user.company.localdatasources.impl.CompanyRateLocalDatasourceImpl
import com.example.kotlin_android_user.company.remotedatasources.CompanyRateRemoteDatasource
import com.example.kotlin_android_user.company.remotedatasources.CompanyRemoteDatasource
import com.example.kotlin_android_user.company.remotedatasources.impl.CompanyRateRemoteDatasourceImpl
import com.example.kotlin_android_user.company.remotedatasources.impl.CompanyRemoteDatasourceImpl
import com.example.kotlin_android_user.company.repositories.CompanyRateRepository
import com.example.kotlin_android_user.company.repositories.CompanyRepository
import com.example.kotlin_android_user.company.repositories.impl.CompanyRateRepositoryImpl
import com.example.kotlin_android_user.company.repositories.impl.CompanyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CompanyModule {
    @Binds abstract fun bindCompanyRepository(companyRepository: CompanyRepositoryImpl?): CompanyRepository?
    @Binds abstract fun bindCompanyRemoteDatasource(companyRemoteDatasource: CompanyRemoteDatasourceImpl?): CompanyRemoteDatasource?
    @Binds abstract fun bindCompanyLocalDatasource(companyLocalDatasource: CompanyLocalDatasourceImpl?): CompanyLocalDatasource?
    @Binds abstract fun bindCompanyRateRemoteDatasource(companyRateRemoteDatasource: CompanyRateRemoteDatasourceImpl?): CompanyRateRemoteDatasource?
    @Binds abstract fun bindCompanyRateLocalDatasource(companyRateLocalDatasource: CompanyRateLocalDatasourceImpl?): CompanyRateLocalDatasource?
    @Binds abstract fun bindCompanyRateRepository(companyRateRepository: CompanyRateRepositoryImpl?):CompanyRateRepository?
}