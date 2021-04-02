package kwikemart.socialnetwork.core.application.usecases

import kwikemart.socialnetwork.core.application.repositories.Users
import kwikemart.socialnetwork.core.domain.entities.Post

class ViewTimeline(
    private val users: Users
) {
    fun execute(usernameWhoWantsToView: String, usernameTimelineBelongs: String): List<Post> {
        val userWhoWantsToView = users.findByUsername(usernameWhoWantsToView) ?: throw RuntimeException("user not exists")
        val userTimelineBelongs = users.findByUsername(usernameTimelineBelongs) ?: throw RuntimeException("user not exists")

        return userTimelineBelongs.timeline(userWhoWantsToView)
    }
}