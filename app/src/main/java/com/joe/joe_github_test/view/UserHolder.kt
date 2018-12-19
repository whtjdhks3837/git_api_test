package com.joe.joe_github_test.view

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joe.joe_github_test.data.User
import com.joe.joe_github_test.databinding.UserItemBinding
import kotlinx.android.synthetic.main.user_item.view.*

class UserHolder(private val context: Context, private val binding: UserItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.username.text = user.name
        Glide.with(context)
            .load(user.imageUrl)
            .into(binding.userImage)
    }
}