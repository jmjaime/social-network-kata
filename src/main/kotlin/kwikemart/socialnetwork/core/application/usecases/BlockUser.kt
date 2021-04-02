package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Blocks
import kwikemart.socialnetwork.core.application.repositories.Users

class BlockUser(
    private val users: Users,
    private val blocks: Blocks,
) {
    fun execute(username: String, usernameToBlock: String) {
        val user = users.findByUsername(username) ?: throw RuntimeException("user not exists")
        val userToBlock = users.findByUsername(usernameToBlock) ?: throw RuntimeException("user not exists")

        // en este caso se que se creo un nuevo block en el sistema,
        // entonces actualizo directamente la colleccion
        blocks.save(user, userToBlock)
    }
}