package com.joe.joe_github_test.api

import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.data.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @GET("users/{name}")
    fun getUserInfo(@Path("name") username: String): Single<User?>

    @GET("users/{name}/repos")
    fun getUserRepos(
        @Path("name") username: String,
        @Query("sort") sort: String = "stargazers_count"
    ): Single<List<Repo>>
}