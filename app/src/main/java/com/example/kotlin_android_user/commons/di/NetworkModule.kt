package com.example.kotlin_android_user.commons.di

import com.example.kotlin_android_user.company.apiservices.CompanyApiService
import com.example.kotlin_android_user.company.apiservices.CompanyRateApiService
import com.example.kotlin_android_user.config.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofitBuilder(okBuilder: OkHttpClient.Builder): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Config.url)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).client(okBuilder.build())
    }

    @Singleton
    @Provides
    fun provideRetrofit(builder: Retrofit.Builder): Retrofit {
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkBuilder(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS).retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
    }

    @Singleton
    @Provides
    fun provideCompanyApi(retrofit: Retrofit): CompanyApiService {
        return retrofit.create(CompanyApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideCompanyRateApi(retrofit: Retrofit): CompanyRateApiService {
        return retrofit.create(CompanyRateApiService::class.java)
    }
}