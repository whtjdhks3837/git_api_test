package com.joe.joe_github_test.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login") @Expose val name: String,
    @SerializedName("avatar_url") @Expose val imageUrl: String?
)