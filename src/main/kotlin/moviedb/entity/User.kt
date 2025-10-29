package moviedb.entity
import main.moviedb.service.UserActions


open class User(val username: String) : UserActions {
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

    override fun printUserDetails() {
        println("User ID: $userId")
        println("Username: $username")
        println("Number of favourites: ${favourites.size}")
    }


    //Set or update a rating (validated) - triggers the (private) setter setUserRating
    override fun rateMedia(media: Media, rating: Int) {
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

        //Get previous user rating - ensure null is valid response
        val previousRating = _userRatings[media]
        //Update the private user rating value _userRating to new rating
        _userRatings[media] = rating
        //Add or update existing user rating value
        media.addOrUpdateRating(this, rating)

        // Show user rating has succeeded - notify if user is adding a rating or updating existing rating
        if (previousRating == null) {
            println("$username rated '${media.title}' with $rating stars.")
        } else {
            println("$username updated rating for '${media.title}' to $rating stars.")
        }
    }

    // Get user's rating for a given media (public visible)
    fun getRatingForMedia(media: Media): Int? = _userRatings[media]


    companion object {
        private var nextId = 1001 //Initialise ID value for very first registered user

        // For each following user, add 1 to ID and return value to a maximum of 9999 users.
        private fun generateNextId(): Int {
            if (nextId > 9999) {
                throw IllegalStateException("Maximum number of users reached (9999).")
            }
            return nextId++
        }
    }
}
