package com.example.socialmediacontrol.android.modules.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.connect.models.User
import com.example.connect.models.Users
import com.example.socialmediacontrol.android.R
import com.example.socialmediacontrol.android.databinding.UserItemBinding
import com.example.socialmediacontrol.android.modules.ui.adapters.interfaces.OnClickUsersItem

class UsersAdapter(private val context: Context) :
    RecyclerView.Adapter<UsersAdapter.UsersAdapterViewHolder>() {
    private lateinit var mCallback: OnClickUsersItem

    var mUsers: Users? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapterViewHolder {
        val binding: UserItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.user_item, parent, false)
        return UsersAdapterViewHolder(binding, mCallback)
    }

    override fun onBindViewHolder(holder: UsersAdapterViewHolder, position: Int) {
        val user = mUsers?.get(position)
        user.let {
            holder.setBind(it!!)
        }
    }

    override fun getItemCount() = mUsers?.size ?: 0

    fun connectFragment(callback: OnClickUsersItem) {
        mCallback = callback
    }

    class UsersAdapterViewHolder(private val binding: UserItemBinding, private val callback : OnClickUsersItem) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBind(userItem: User) {
            binding.user = userItem
            binding.callback = callback
        }
    }
}