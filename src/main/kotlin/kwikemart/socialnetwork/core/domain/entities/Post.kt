package kwikemart.socialnetwork.core.domain.entities

data class Post(val message: String, val author: User) {
    init {
        // esta regla de negocio se puede seguir manteniendo
        check(message.length <= 280) { "message must be less than 280 characters" }
    }
}