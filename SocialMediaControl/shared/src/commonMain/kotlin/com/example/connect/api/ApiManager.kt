package com.example.connect.api

import com.example.connect.manager.EndPoint
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import android.util.Log

object ApiManager  {
    suspend inline fun <reified T>getServer(url : String) :T{
        val TAG = "REQUEST"
        val BASEURL = EndPoint.PROD.value
        val httpClient : HttpClient = HttpClient() {
            install(JsonFeature){
                serializer = KotlinxSerializer()
            }
        }
        Log.d(TAG,url)
        return httpClient.get(BASEURL+url) as T
    }
}