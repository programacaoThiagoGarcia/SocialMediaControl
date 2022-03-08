package com.example.socialmediacontrol.android.modules.ui.fragments

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.socialmediacontrol.android.R
import com.example.socialmediacontrol.android.databinding.UserDetailFragmentBinding
import com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel.UserDetailViewModel
import com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel.factory.UserDetailViewModelFactory
import com.squareup.picasso.Picasso

class UserDetail : Fragment() {

    companion object {
        fun newInstance() = UserDetail()
    }

    private lateinit var mViewModel: UserDetailViewModel
    private lateinit var userId: String
    private lateinit var mBinding: UserDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getArgs()
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_detail_fragment, container, false)
        mBinding.apply {
            lifecycleOwner = this@UserDetail
        }
        return mBinding.root
    }

    private fun getArgs() {
        val args = arguments?.let {
            UserDetailArgs.fromBundle(it)
        }
        args?.let {
            userId = args.userId
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prepareViewModel()
        prepareDataSource()
    }


    private fun prepareDataSource() {
        mViewModel.detailUser.observe(viewLifecycleOwner) {
            mBinding.viewModel = mViewModel
            Picasso.get().load(it.imageUrl).into(mBinding.ivUserAvatar)
        }
    }

    private fun prepareViewModel() {
        val factory = UserDetailViewModelFactory(userId)
        mViewModel = ViewModelProvider(this, factory)[UserDetailViewModel::class.java]
    }

}