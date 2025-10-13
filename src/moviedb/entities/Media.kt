package moviedb.entities
//Media class should include common variable for Movies and TV Series: Title, Synopsis, Genre, Actors, User Rating

abstract class Media(val title: String,
                 val synopsis: String,
                 val genre: String,
                 val actors: List<String>,
                 var userRating: Double = 0.0
) {
    open fun printDetails()  // each subclass must implement
    { //TODO
    }
}