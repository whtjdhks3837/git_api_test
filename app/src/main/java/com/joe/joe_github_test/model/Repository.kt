package com.joe.joe_github_test.model

import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.data.User
import io.reactivex.Single

interface Repository {
    fun getUserInfo(username: String): Single<User?>
    fun getUserRepos(username: String): Single<List<Repo>>
}