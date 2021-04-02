package kwikemart.socialnetwork.core.application.repositories

import kwikemart.socialnetwork.core.domain.entities.Post
import kwikemart.socialnetwork.core.domain.entities.User

interface Posts {
    fun save(post: Post)
    fun findByAuthor(author: User): List<Post>
}