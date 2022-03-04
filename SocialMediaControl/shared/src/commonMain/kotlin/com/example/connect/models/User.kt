package com.example.connect.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("address")
    val address: Address,
    @SerialName("company")
    val company: Company,
    @SerialName("email")
    val email: String,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("username")
    val username: String,
    @SerialName("website")
    val website: String,
    val imageUrl: String = "https://picsum.photos/id/${id}/80/80"
)
typealias Users = List<User>