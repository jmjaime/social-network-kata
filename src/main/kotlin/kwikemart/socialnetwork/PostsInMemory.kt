package kwikemart.socialnetwork

import kwikemart.socialnetwork.model.Post

class PostsInMemory : Posts {

    override fun add(post: Post): Post {
        return Post(message = "Hello world!")
    }
}