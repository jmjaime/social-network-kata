package kwikemart.socialnetwork

import kwikemart.socialnetwork.model.Post
import org.springframework.stereotype.Repository

@Repository
interface Posts {
    fun add(post: Post): Post
}