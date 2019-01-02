package com.joe.joe_github_test.view

import android.content.Context
import com.bumptech.glide.Glide
import com.joe.joe_github_test.data.User
import com.joe.joe_github_test.databinding.UserItemBinding

class UserViewHolder(private val binding: UserItemBinding) :
    BaseViewHolder<User>(binding) {

    override fun bind(user: User) {
        binding.username.text = user.name
        Glide.with(itemView.context)
            .load(user.imageUrl)
            .into(binding.userImage)
    }
}