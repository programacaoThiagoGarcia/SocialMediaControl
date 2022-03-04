package com.example.connect.manager

import com.example.connect.api.ApiManager
import com.example.connect.models.*

class ConnectManager {

    //Get Users
    suspend fun getUsers(): Users {
        return ApiManager.getServer(Path.USER.value)
    }

    // Get User Detail
    suspend fun getUserDetail(id: String): User {
        return ApiManager.getServer(PrepareUrl.prepareUrl(id,Path.USER_DETAIL))
    }

    // Get User Post
    suspend fun getUserPost(id: String): Posts {
        return ApiManager.getServer(PrepareUrl.prepareUrl(id,Path.POSTS))
    }

    // Get Post Comments
    suspend fun getPostComments(postId: String): Comments {
        return ApiManager.getServer(PrepareUrl.prepareUrl(postId,Path.COMMENTS ))
    }

    // Get Albums
    suspend fun getAlbums(userId: String): Albums {
        return ApiManager.getServer(PrepareUrl.prepareUrl(userId, Path.ALBUM))
    }

    // Get  Photos
    suspend fun getPhotos(albumId: String): Photos {
        return ApiManager.getServer(PrepareUrl.prepareUrl(albumId,Path.PHOTO))
    }

}

