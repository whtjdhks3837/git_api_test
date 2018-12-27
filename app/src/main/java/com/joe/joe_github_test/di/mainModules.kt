package com.joe.joe_github_test.di

import com.joe.joe_github_test.model.NetworkRepository
import com.joe.joe_github_test.model.Repository
import com.joe.joe_github_test.view.UserAdapter
import com.joe.joe_github_test.viewmodel.MainViewModelFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val mainModules = module {
    factory {
        NetworkRepository(get()) as Repository
    }
    factory {
        MainViewModelFactory(get())
    }
    factory {
        UserAdapter(androidContext())
    }
}