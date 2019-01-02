package com.joe.joe_github_test.di

import com.joe.joe_github_test.api.RetrofitService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val url = "https://api.github.com/"
val retrofitModule = module {
    single {
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(get())
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
            .create(RetrofitService::class.java)
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        } as Interceptor
    }
}