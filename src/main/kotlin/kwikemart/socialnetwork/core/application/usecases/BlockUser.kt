package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Users

class BlockUser(
    private val users: Users
) {
    fun execute(username: String, usernameToBlock: String) {
        val user = users.findByUsername(username) ?: throw RuntimeException("user not exists")
        val userToBlock = users.findByUsername(usernameToBlock) ?: throw RuntimeException("user not exists")

        user.block(userToBlock)

        // termino actualizando todoo el user en la db cuando lo que quiero
        // es agregar un user blockeado a la collection de bloqueados
        users.save(user)
    }
}