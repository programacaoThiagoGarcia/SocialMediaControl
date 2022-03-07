package com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connect.manager.ConnectManager
import com.example.connect.models.Users
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class UsersViewModel() : ViewModel() {
    private val mainScope = MainScope()


    private val mLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val loading: LiveData<Boolean>
        get() = mLoading

    private val mUsers: MutableLiveData<Users> by lazy {
        MutableLiveData<Users>()
    }
    val users: LiveData<Users>
        get() = mUsers

    init {
        getUsers()
    }

    private fun getUsers() {
        mLoading.value = true
        mainScope.launch {
            kotlin.runCatching {
                ConnectManager().getUsers()
            }.onSuccess {
                mLoading.value = false
                mUsers.value = it
            }.onFailure {
                mLoading.value = false
            }
        }
    }
}