package main.moviedb.entities
//Media class should include common variable for Movies and TV Series: Title, Synopsis, Genre, Actors, User Rating

abstract class Media(val title: String,
                 val synopsis: String,
                 val genre: String,
                 val actors: List<String>,
                 var userRating: Double = 0.0
) {
    val ratings: MutableMap<User, Int> = mutableMapOf()

    //Add or update user rating for a given media
    fun addOrUpdateRating(user: User, rating: Int) {
        ratings[user] = rating
    }

    //Calculate avg rating for a media
    fun getAverageRating(): Double {
        if (ratings.isEmpty()) return 0.0
        return ratings.values.average()
    }

    //Show a given media's rating and number of rating
    fun printMediaAvgRatingDetails(): String {
        val avg = "%.2f".format(getAverageRating())
        return "Title: $title | Average Rating: $avg | Total Ratings: ${ratings.size}"
    }


    open fun printDetails()  // each subclass must implement
    { //TODO
    }
}