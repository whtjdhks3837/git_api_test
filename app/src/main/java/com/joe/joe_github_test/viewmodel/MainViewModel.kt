package com.joe.joe_github_test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joe.joe_github_test.data.Repo
import com.joe.joe_github_test.data.User
import com.joe.joe_github_test.model.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val repository: Repository) : BaseViewModel() {

    private val _user = MutableLiveData<User>()
    private val _repos = MutableLiveData<List<Repo>>()
    private val _error = MutableLiveData<String>()
    private val _progress = MutableLiveData<Boolean>()

    val user: LiveData<User> = _user
    val repos: LiveData<List<Repo>> = _repos
    val error: LiveData<String> = _error
    val progress: LiveData<Boolean> = _progress

    fun getUserInfo(username: String) {
        addDisposable(
            repository.getUserInfo(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it != null)
                        _user.value = it
                    else
                        _error.value = "유저를 찾을 수 없습니다."
                }, {
                    _error.value = "유저를 찾을 수 없습니다."
                })
        )
    }

    fun getUserRepo(username: String) {
        addDisposable(
            repository.getUserRepos(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (!it.isEmpty())
                        _repos.value = it
                    else
                        _error.value = "레포지토리가 없습니다."
                }, {
                    _error.value = "서버연결에 실패했습니다."
                })
        )
    }

    fun setProgress(isLoading: Boolean) {
        _progress.value = isLoading
    }
}