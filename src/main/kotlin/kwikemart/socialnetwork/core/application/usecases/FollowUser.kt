package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Users

class FollowUser(
    private val users: Users
) {
    fun execute(username: String, usernameToFollow: String) {
        val user = users.findByUsername(username) ?: throw RuntimeException("user not exists")
        val userToFollow = users.findByUsername(usernameToFollow) ?: throw RuntimeException("user not exists")

        user.follow(userToFollow)

        // termino actualizando todoo el user en la db cuando lo que quiero
        // es agregar un user blockeado a la collection de bloqueados
        users.save(user)
    }
}