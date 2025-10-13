package moviedb.entities
//Movie class should include Title, Release Year, Runtime, Synopsis, Genre, Director, Actors, User Rating
//Inherit Title, Synopsis, Genre and Actors from Media class

class Movie (title: String,
             val releaseYear: Int,
             val runtime: Int,
             synopsis: String,
             genre: String,
             val director: String,
             actors: List<String>) : Media(title, synopsis, genre, actors
             ){
    override fun printDetails() {
        println("=== Movie Details ===")
        println("Title: $title")
        println("Release Year: $releaseYear")
        println("Runtime: $runtime min")
        println("Director: $director")
        println("Genre: $genre")
        println("Actors: ${actors.joinToString(", ")}")
        println("Synopsis: $synopsis")
        println("User Rating: $userRating")
        println("=====================")
    }

}