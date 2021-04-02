package kwikemart.socialnetwork.core.application.repositories

import kwikemart.socialnetwork.core.domain.entities.User

interface Blocks {
    fun save(user: User, userToBlock: User)
    fun exists(user: User, blockedUser: User): Boolean
}