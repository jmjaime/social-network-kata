package kwikemart.socialnetwork.core.domain.entities

// el User termina siendo una clase con muchas responsabilidades
// y a veces validando cosas que quizas no le corresponden
class User(
    username: String,
) {
    private val username: String = username
    private val posts: MutableList<Post> = mutableListOf()
    private val blocks: MutableList<User> = mutableListOf()
    private val follows: MutableList<User> = mutableListOf()

    init {
        check(username.isNotEmpty()) { "Username cannot be empty" }
    }

    fun addPost(post: Post) {
        this.posts.add(post)
    }

    fun getPosts(): List<Post> = posts

    fun block(user: User) {
        blocks.add(user)
    }

    fun follow(user: User) {
        if (user.hasBlock(this))
            throw RuntimeException("$user has block $this so can't follow")

        follows.add(user)
    }

    // en la vida real no voy a obtener todos los posts
    // sino que los voy a obtener paginados
    fun timeline(userWhoWantsToView: User): List<Post> {
        // chequear esta regla realmente le corresponde al User ?
        if (this.hasBlock(userWhoWantsToView))
            throw RuntimeException("$this has block $userWhoWantsToView so can't view timeline")

        return posts
    }

    private fun hasBlock(user: User) = blocks.contains(user)
}
