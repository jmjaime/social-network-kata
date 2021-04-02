package kwikemart.socialnetwork.core.application.repositories

import kwikemart.socialnetwork.core.domain.entities.User

interface Users {

    fun save(user: User): User

    fun findByUsername(username: String): User?

}