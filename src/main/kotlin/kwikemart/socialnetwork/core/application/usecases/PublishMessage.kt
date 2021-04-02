package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Posts
import kwikemart.socialnetwork.core.application.repositories.Users
import kwikemart.socialnetwork.core.domain.entities.Post

class PublishMessage(
    private val users: Users,
    private val posts: Posts,
) {

    fun execute(username: String, message: String) {
        val user = users.findByUsername(username) ?: throw RuntimeException("user not exists")
        val post = Post(message, user)

        // en este caso se que se creo un nuevo post en el sistema,
        // entonces actualizo directamente la colleccion
        posts.save(post)
    }

}