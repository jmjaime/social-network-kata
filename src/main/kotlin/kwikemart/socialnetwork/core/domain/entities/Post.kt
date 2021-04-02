package kwikemart.socialnetwork.core.domain.entities

data class Post(val message: String) {
    init {
        check(message.length <= 280) { "message must be less than 280 characters" }
    }
}