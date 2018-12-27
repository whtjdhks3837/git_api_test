package com.joe.joe_github_test.view

import android.content.Context
import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.databinding.RepoListItemBinding

class ReposViewHolder(private val context: Context, private val binding: RepoListItemBinding) :
    BaseViewHolder<Repo>(binding) {

    override fun bind(repo: Repo) {
        binding.name.text = repo.name
        repo.description?.let { binding.discription.text = it }
        binding.star.text = repo.starCount
    }
}