package com.example.socialmediacontrol.android.modules.ui.fragments

import android.app.Activity
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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.connect.models.User
import com.example.socialmediacontrol.android.R
import com.example.socialmediacontrol.android.databinding.UsersFragmentBinding
import com.example.socialmediacontrol.android.modules.ui.adapters.UsersAdapter
import com.example.socialmediacontrol.android.modules.ui.adapters.interfaces.OnClickUsersItem
import com.example.socialmediacontrol.android.modules.ui.fragments.viewmodel.UsersViewModel

class Users : Fragment(), OnClickUsersItem {

    companion object {
        fun newInstance() = Users()
    }

    private lateinit var mViewModel: UsersViewModel
    private lateinit var mBinding: UsersFragmentBinding
    private lateinit var mAdapter: UsersAdapter
    private val TAG = "USERS_FRAGMENT"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.users_fragment, container, false)
        mBinding.apply {
            this.lifecycleOwner = this@Users
        }
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        prepareAdapter()
        prepareRecyclerView()
        prepareViewModel()
        prepareDataSource()

    }

    private fun prepareDataSource() {
        mViewModel.users.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, it.toString())
            mAdapter.mUsers = it
        })
    }

    private fun prepareViewModel() {
        mViewModel = ViewModelProvider(this)[UsersViewModel::class.java]
        mBinding.viewmodel = mViewModel
    }

    private fun prepareRecyclerView() {
        mBinding.rvUsers.apply {
            setHasFixedSize(true)
            layoutManager = activity?.let {
                GridLayoutManager(context, 3)
            }
            adapter = mAdapter
        }
    }

    private fun prepareAdapter() {
        mAdapter = context?.let { UsersAdapter(it) }!!
        mAdapter.connectFragment(this)

    }

    override fun onClickItem(user: User) {
        Log.d(TAG, user.toString())
        view?.let {
            it.findNavController().navigate(UsersDirections.actionUsersToUserDetail(userId = user.id.toString()))
        }
    }

}