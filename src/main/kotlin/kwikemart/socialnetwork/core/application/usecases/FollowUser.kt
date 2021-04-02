package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Blocks
import kwikemart.socialnetwork.core.application.repositories.Follows
import kwikemart.socialnetwork.core.application.repositories.Users

class FollowUser(
    private val users: Users,
    private val blocks: Blocks,
    private val follows: Follows,
) {
    fun execute(username: String, usernameToFollow: String) {
        val user = users.findByUsername(username) ?: throw RuntimeException("user not exists")
        val userToFollow = users.findByUsername(usernameToFollow) ?: throw RuntimeException("user not exists")

        // aca directamente pregunto si tal usuario bloqueo a tal otro usuario
        // no hace falta que cargue todos los usuarios bloqueados en memoria
        // que no se cuantos pueden llegar a ser
        if (blocks.exists(userToFollow, user))
            throw RuntimeException("$userToFollow has block $user so can't follow")

        follows.save(user, userToFollow)
    }
}