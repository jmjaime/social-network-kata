package kwikemart.socialnetwork

import kwikemart.socialnetwork.model.Post
import kwikemart.socialnetwork.model.User

class UsersInMemory : Users {

    override fun findByUsername(userName: String): User? {
        return User(
                userName = "pepe",
                posts = mutableListOf(
                        Post(
                                message = "Hello world!"
                        )
                )
        )
    }
}