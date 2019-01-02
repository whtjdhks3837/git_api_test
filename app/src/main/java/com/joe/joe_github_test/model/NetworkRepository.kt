package com.joe.joe_github_test.model

import com.joe.joe_github_test.api.RetrofitService
import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.data.User
import io.reactivex.Single

class NetworkRepository(private val retrofitService: RetrofitService) : Repository {
    override fun getUserInfo(username: String) = retrofitService.getUserInfo(username)
    override fun getUserRepos(username: String)= retrofitService.getUserRepos(username)
}