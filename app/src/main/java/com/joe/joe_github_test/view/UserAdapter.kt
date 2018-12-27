package com.joe.joe_github_test.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.data.User
import com.joe.joe_github_test.databinding.RepoListItemBinding
import com.joe.joe_github_test.databinding.UserItemBinding

class UserAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var user: User
    private val repos = mutableListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> UserViewHolder(context, UserItemBinding.
                inflate(LayoutInflater.from(parent.context), parent, false))
            else -> ReposViewHolder(context, RepoListItemBinding.
                inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as UserViewHolder).bind(user)
            else -> (holder as ReposViewHolder).bind(repos[position])
        }
    }

    fun setUser(user: User) {
        this.user = user
    }

    fun setRepos(repos: List<Repo>) {
        this.repos.clear()
        this.repos.addAll(repos)
        notifyDataSetChanged()
    }
}