package kwikemart.socialnetwork.model

data class User(
        val userName: String,
        private val posts: MutableList<Post>
) {

    init {
        check(userName.isNotEmpty()) { "Username cannot be empty" }
    }

    fun addPost(post: Post) {
        this.posts.add(post)
    }
}