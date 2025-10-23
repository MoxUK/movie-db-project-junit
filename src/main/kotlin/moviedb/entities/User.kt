package main.moviedb.entities
import main.moviedb.service.UserActions

class User(val username: String) : UserActions {
    val userId: Int
    val favourites: MutableList<Media> = mutableListOf()
    private val _userRatings: MutableMap<Media, Int> = mutableMapOf() //ensure user rating is private

    // Public read-only view of user rating
    val userRatings: Map<Media, Int>
        get() = _userRatings.toMap() // returns a copy so it's read-only externally


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


    //Set or update a rating (validated)
    fun rateMedia(media: Media, rating: Int) {
        setUserRating(media, rating)
    }

    /** // Rate media (per user)
    fun rateMedia(media: Media, rating: Int) {
        require(rating in 1..5) { "Rating must be between 1 and 5." }

        val previousRating = userRatings[media]
        userRatings[media] = rating
        media.addOrUpdateRating(this, rating)

        if (previousRating == null) {
            println("$username rated '${media.title}' with $rating stars.")
        } else {
            println("$username updated rating for '${media.title}' to $rating stars.")
        }
    }*/

    // Private setter with validation
    private fun setUserRating(media: Media, rating: Int) {
        require(rating in 1..5) { "Rating must be between 1 and 5." }

        val previousRating = _userRatings[media]
        _userRatings[media] = rating
        media.addOrUpdateRating(this, rating)

        if (previousRating == null) {
            println("$username rated '${media.title}' with $rating stars.")
        } else {
            println("$username updated rating for '${media.title}' to $rating stars.")
        }
    }

    // Get user's rating for a given media
    fun getRatingForMedia(media: Media): Int? = _userRatings[media]
    /**
    fun getRatingForMedia(media: Media): Int? {
        return userRatings[media]
    }
    */

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
