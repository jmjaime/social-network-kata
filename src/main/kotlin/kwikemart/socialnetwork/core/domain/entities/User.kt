package kwikemart.socialnetwork.core.domain.entities

data class User(val username: String) {
    init {
        // esta regla de negocio se puede seguir manteniendo
        check(username.isNotEmpty()) { "Username cannot be empty" }
    }
}
