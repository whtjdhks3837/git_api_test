package com.joe.joe_github_test.viewmodel

import androidx.lifecycle.MutableLiveData
import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.data.User
import com.joe.joe_github_test.model.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: Repository) : BaseViewModel() {

    val user = MutableLiveData<User>()
    val repos = MutableLiveData<List<Repo>>()
    val error = MutableLiveData<String>()
    val progress = MutableLiveData<Boolean>()

    fun getUserInfo(username: String) {
        addDisposable(repository.getUserInfo(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it != null)
                    user.value = it
                else
                    error.value = "유저를 찾을 수 없습니다."
            }, {
                it.printStackTrace()
                error.value = "유저를 찾을 수 없습니다."
            })
        )
    }

    fun getUserRepo(username: String) {
        addDisposable(repository.getUserRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                repos.value = it
            }, {
                it.printStackTrace()
                error.value = "레포지토리가 없습니다."
            })
        )
    }
}