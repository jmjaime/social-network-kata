package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Users
import kwikemart.socialnetwork.core.domain.entities.Post

class PublishMessage(
    private val users: Users
) {

    fun execute(username: String, message: String) {
        val user = users.findByUsername(username) ?: throw RuntimeException("user not exists")
        val post = Post(message)

        user.addPost(post)

        // termino actualizando todoo el user en la db cuando lo que quiero
        // es agregar un post a la collection de posts
        users.save(user)
    }

}