package com.example.connect.manager

enum class EndPoint(val value:String){
    PROD("https://jsonplaceholder.typicode.com"),
    DEV("")
}

enum class Path(val value: String) {
    USER("/users"),
    USER_DETAIL("/users/{id}"),
    POSTS("/user/{id}/posts"),
    COMMENTS("/post/{id}/comments"),
    ALBUM("/user/{id}/albums"),
    PHOTO("/album/{id}/photos")
}

object PrepareUrl{
    fun prepareUrl(id : String, path: Path) = path.value.replace("{id}",id)
}
