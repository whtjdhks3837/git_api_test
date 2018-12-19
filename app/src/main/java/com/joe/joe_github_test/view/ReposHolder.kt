package com.joe.joe_github_test.view

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.databinding.RepoListItemBinding

class ReposHolder(private val context: Context, private val binding: RepoListItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(repo: Repo) {
        binding.name.text = repo.name
        repo.description?.let { binding.discription.text = it }
        binding.star.text = repo.starCount
    }
}