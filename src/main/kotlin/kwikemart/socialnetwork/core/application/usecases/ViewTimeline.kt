package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Blocks
import kwikemart.socialnetwork.core.application.repositories.Posts
import kwikemart.socialnetwork.core.application.repositories.Users
import kwikemart.socialnetwork.core.domain.entities.Post

class ViewTimeline(
    private val users: Users,
    private val blocks: Blocks,
    private val posts: Posts,
) {
    fun execute(usernameWhoWantsToView: String, usernameTimelineBelongs: String): List<Post> {
        val userWhoWantsToView = users.findByUsername(usernameWhoWantsToView) ?: throw RuntimeException("user not exists")
        val userTimelineBelongs = users.findByUsername(usernameTimelineBelongs) ?: throw RuntimeException("user not exists")

        if (blocks.exists(userTimelineBelongs, userWhoWantsToView))
            throw RuntimeException("$userTimelineBelongs has block $userWhoWantsToView so can't view timeline")

        // aca si se puede paginar
        return posts.findByAuthor(userTimelineBelongs)
    }
}