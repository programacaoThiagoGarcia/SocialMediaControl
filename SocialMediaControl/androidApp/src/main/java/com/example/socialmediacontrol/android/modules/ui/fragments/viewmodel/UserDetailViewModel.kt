package com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connect.manager.ConnectManager
import com.example.connect.models.User
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class UserDetailViewModel(private val userId : String) : ViewModel() {
    private val mMainScope = MainScope()

    private val mLoading : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    val loading : LiveData<Boolean>
    get() = mLoading

    private val mDetailUser : MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
    val detailUser : LiveData<User>
    get() = mDetailUser

    init {
        getUserDetail()
    }

   private fun getUserDetail(){
        mLoading.value = true
        mMainScope.launch {
            kotlin.runCatching {
                ConnectManager().getUserDetail(userId)
            }.onSuccess {
                mLoading.value = false
                Log.d("USER",it.toString())
                mDetailUser.value = it
            }.onFailure {
                mLoading.value = false
            }
        }
    }

}