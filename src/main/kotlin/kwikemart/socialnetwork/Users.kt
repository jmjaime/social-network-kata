package kwikemart.socialnetwork

import kwikemart.socialnetwork.model.User
import org.springframework.stereotype.Repository

@Repository
interface Users {

    fun save(user: User): User

    fun findByUsername(username: String): User?

}