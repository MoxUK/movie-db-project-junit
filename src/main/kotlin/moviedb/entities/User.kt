package main.moviedb.entities
import main.moviedb.service.UserActions

class User(val username: String) : UserActions {
    val userId: Int
    val favourites: MutableList<Media> = mutableListOf()

    init {
        userId = generateNextId()
    }

    override fun addFavorite(media: Media) {
        //Check if favorite is already on list; if not then add to list and confirm
        if (!favourites.contains(media)) {
            favourites.add(media)
            println("${media.title} added to $username's favorites.")
        } else {
            println("${media.title} already exists on $username's favorites.")
        }
    }

    override fun removeFavorite(media: Media) {
        //Remove favourite from list; if the element doesn't exist on the list, remove does nothing so no need to check
        if (favourites.remove(media)) {
            println("${media.title} removed from $username's favorites.")
        } else {
            println("${media.title} was not in $username's favorites.")
        }
    }

    override fun showFavourites() {
        //Check if list is empty; if not, then print each entry using build-in forEach to step through list
        if (favourites.isEmpty()) {
            println("$username's favourite list is empty")
        } else {
            println("$username's favorite titles:")
            favourites.forEach { println("- ${it.title}") }
        }
    }

    fun printUserDetails() {
        println("User ID: $userId")
        println("Username: $username")
        println("Number of favourites: ${favourites.size}")
    }

    companion object {
        private var nextId = 1001

        private fun generateNextId(): Int {
            if (nextId > 9999) {
                throw IllegalStateException("Maximum number of users reached (9999).")
            }
            return nextId++
        }
    }
}
