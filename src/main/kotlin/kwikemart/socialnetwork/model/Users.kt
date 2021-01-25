package kwikemart.socialnetwork.model

interface Users {

    fun findByUsername(usernam: String): User?
}