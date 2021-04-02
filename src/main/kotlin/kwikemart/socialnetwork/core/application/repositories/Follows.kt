package kwikemart.socialnetwork.core.application.repositories

import kwikemart.socialnetwork.core.domain.entities.User

interface Follows {
    fun save(user: User, userToFollow: User)
}