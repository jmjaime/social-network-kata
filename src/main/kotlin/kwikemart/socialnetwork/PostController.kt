package kwikemart.socialnetwork

import kwikemart.socialnetwork.model.Post
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users/{userName}/posts")
class PostController(val users: Users, val posts: Posts) {

    @PostMapping
    fun publish(@RequestBody post: Post, @PathVariable userName: String) {
        val user = this.users.findByUsername(userName) ?: throw RuntimeException()

        user.addPost(post)
        this.users.save(user)
    }

    @GetMapping
    fun getAllPosts(@PathVariable userName: String): List<Post> {
        return this.users.findByUsername(userName)?.getPosts() ?: throw RuntimeException()
    }

}