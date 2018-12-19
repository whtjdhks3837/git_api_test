package com.joe.joe_github_test.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("name") @Expose val name: String,
    @SerializedName("description") @Expose val description: String?,
    @SerializedName("stargazers_count") @Expose val starCount: String
)