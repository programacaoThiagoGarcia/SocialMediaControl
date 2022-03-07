package com.example.socialmediacontrol.android.modules.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.socialmediacontrol.android.R
import com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel.UserDetailViewModel

class UserDetail : Fragment() {

    companion object {
        fun newInstance() = UserDetail()
    }

    private lateinit var viewModel: UserDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}