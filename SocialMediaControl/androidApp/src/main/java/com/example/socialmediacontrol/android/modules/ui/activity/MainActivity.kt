package com.example.socialmediacontrol.android.modules.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.connect.manager.ConnectManager
import com.example.socialmediacontrol.android.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()
    private val TAG = "ACTIVITY"
    var connectManager: ConnectManager = ConnectManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        getUsers()
        getUserDetail()
        getUserPosts()
        getPostComment()
        getUserAlbums()
        getAlbumsPhotos()

         */
    }

    private fun getAlbumsPhotos() {
        mainScope.launch {
            kotlin.runCatching {
                connectManager.getPhotos("1")
            }.onSuccess {
                Log.d(TAG,"PHOTOS")
                Log.d(TAG, it.toString())
            }.onFailure {
                Log.d(TAG, it.localizedMessage)
            }
        }
    }

    private fun getUserAlbums() {
        mainScope.launch {
            kotlin.runCatching {
                connectManager.getAlbums("1")
            }.onSuccess {
                Log.d(TAG,"ALBUMS")
                Log.d(TAG, it.toString())
            }.onFailure {
                Log.d(TAG, it.localizedMessage)
            }
        }
    }

    private fun getPostComment() {
        mainScope.launch {
            kotlin.runCatching {
                connectManager.getPostComments("1")
            }.onSuccess {
                Log.d(TAG,"COMMENTS")
                Log.d(TAG, it.toString())
            }.onFailure {
                Log.d(TAG, it.localizedMessage)
            }
        }
    }

    private fun getUserPosts() {
        mainScope.launch {
            kotlin.runCatching {
                connectManager.getUserPost("1")
            }.onSuccess {
                Log.d(TAG,"POSTS")
                Log.d(TAG, it.toString())
            }.onFailure {
                Log.d(TAG, it.localizedMessage)
            }
        }
    }

    private fun getUserDetail() {
        mainScope.launch {
            kotlin.runCatching {
                connectManager.getUserDetail("1")
            }.onSuccess {
                Log.d(TAG,"USER")
                Log.d(TAG, it.toString())
            }.onFailure {
                Log.d(TAG, it.localizedMessage)
            }
        }
    }

    private fun getUsers() {
        mainScope.launch {
            kotlin.runCatching {
                connectManager.getUsers()
            }.onSuccess {
                Log.d(TAG,"USERS")
                Log.d(TAG, it.toString())
            }.onFailure {
                Log.d(TAG, it.localizedMessage)
            }
        }
    }
}
