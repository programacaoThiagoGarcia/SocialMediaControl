package com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel.UserDetailViewModel

class UserDetailViewModelFactory(private val userId : String ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailViewModel(userId) as T
    }
}