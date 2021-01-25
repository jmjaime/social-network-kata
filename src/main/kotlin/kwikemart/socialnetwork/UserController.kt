package kwikemart.socialnetwork

import kwikemart.socialnetwork.model.Post
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(val users: Users, val posts: Posts) {

    @PostMapping("/{user}")
    fun publish(@RequestBody post: Post, @PathVariable userName: String) {
        val user = this.users.findByUsername(userName) ?: throw RuntimeException()

        this.posts.add(post)
                .let {
                    user.addPost(it)
                    this.users.save(user)
                }
    }
}