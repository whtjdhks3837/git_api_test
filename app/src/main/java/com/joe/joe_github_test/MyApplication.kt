package com.joe.joe_github_test

import android.app.Application
import com.joe.joe_github_test.di.appModules
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}