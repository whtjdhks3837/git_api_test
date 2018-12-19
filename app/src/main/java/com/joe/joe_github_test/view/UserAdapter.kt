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
            0 -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = UserItemBinding.inflate(inflater, parent, false)
                UserHolder(context, binding)
            }
            else -> {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RepoListItemBinding.inflate(inflater, parent, false)
                ReposHolder(context, binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                (holder as UserHolder).bind(user)
            }
            else -> {
                (holder as ReposHolder).bind(repos[position])
            }
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