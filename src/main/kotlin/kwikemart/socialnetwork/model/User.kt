package kwikemart.socialnetwork.model

data class User(val userName: String, val posts:List<Post>){
    init {
        check(userName.isNotEmpty()) { "Username cannot be empty" }
    }
}