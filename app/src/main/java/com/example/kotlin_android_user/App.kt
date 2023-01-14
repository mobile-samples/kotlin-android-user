package com.example.kotlin_android_user;

import android.app.Application
//import com.example.kotlin_android_user.commons.di.AppComponent
//import com.example.kotlin_android_user.commons.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {
//    lateinit var appComponent: AppComponent
//    override fun onCreate() {
//        super.onCreate()
//        appComponent = DaggerAppComponent.builder().setApplication(this).build()
//
//    }
}
