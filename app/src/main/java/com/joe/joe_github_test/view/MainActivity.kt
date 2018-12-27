package com.joe.joe_github_test.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.joe.joe_github_test.R
import com.joe.joe_github_test.data.User
import com.joe.joe_github_test.databinding.ActivityMainBinding
import com.joe.joe_github_test.viewmodel.MainViewModel
import com.joe.joe_github_test.viewmodel.MainViewModelFactory
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int = R.layout.activity_main
    private val mainViewModelFactory: MainViewModelFactory by inject()
    private val userAdapter: UserAdapter by inject()
    private var username = "whtjdhks3837"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainViewModel::class.java)

        if (Intent.ACTION_VIEW == intent.action) {
            intent.data.getQueryParameter("username")?.let {
                username = it
            }
        }

        viewDataBinding.repoList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }

        viewModel.user.observe(this, Observer {
            userAdapter.setUser(it)
            viewModel.getUserRepo(username)
        })

        viewModel.repos.observe(this, Observer {
            viewModel.setProgress(false)
            userAdapter.setRepos(it)
        })

        viewModel.error.observe(this, Observer {
            viewModel.setProgress(false)
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewDataBinding.viewmodel = viewModel
        viewDataBinding.setLifecycleOwner(this)

        viewModel.setProgress(true)
        viewModel.getUserInfo(username)
    }
}
