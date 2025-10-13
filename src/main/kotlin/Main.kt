import main.moviedb.service.MovieDatabase
import main.moviedb.service.impl.MovieDatabaseImpl
import main.moviedb.entities.Movie
import main.moviedb.entities.User
import main.moviedb.entities.TVSeries
import main.moviedb.entities.Episode



fun main() {
    val db: MovieDatabase = MovieDatabaseImpl()

    // Create media objects (movie)
    val bladerunner = Movie(
        title = "Blade Runner",
        releaseYear = 1982,
        runtime = 117,
        synopsis = "A blade runner must pursue and terminate four replicants who stole a ship in space " +
                "and have returned to Earth to find their creator..",
        genre = "Sci-Fi",
        director = "Ridley Scott",
        actors = listOf("Harrison Ford", "Rutger Hauer", "M. Emmet Walsh")
    )

    val indianajones = Movie(
        title = "Raiders of the Lost Ark",
        releaseYear = 1981,
        runtime = 115,
        synopsis = "In 1936, archaeologist Indiana Jones is tasked by Army Intelligence to help locate a legendary " +
                "ancient power, the Ark of Covenant, before the Nazis get it first.",
        genre = "Action, Adventure",
        director = "Steven Spielberg",
        actors = listOf("Harrison Ford", "Karen Allen", "Paul Freeman")
    )

    val guardiansofthegalaxy = Movie(
        title = "Guardians of the Galaxy",
        releaseYear = 2014,
        runtime = 121,
        synopsis = "A group of intergalactic criminals must pull together to stop a fanatical warrior with " +
                "plans to purge the universe.",
        genre = "Sci-fi, Action, Adventure",
        director = "James Gunn",
        actors = listOf("Chris Pratt", "Vin Diesel", "Dave Bautista")
    )

    // Add media (movies) to Database (db)
    db.addMedia(bladerunner)
    db.addMedia(indianajones)
    db.addMedia(guardiansofthegalaxy)

    // Create media objects (tv serie)
    val wednesday = TVSeries(
        title = "Wednesday",
        pilotDate = "2022-11-23",
        synopsis = "Smart, sarcastic and a little dead inside, Wednesday Addams investigates a murder " +
                "spree while making new friends — and foes — at Nevermore Academy.",
        genre = "Comedy, Drama, Fantasy, Horror, Mystery",
        actors = listOf("Jenny Ortega", "Emma Myers", "Catherine Zeta-Jones")
    )

    val rickandmorty = TVSeries(
        title = "Rick and Morty",
        pilotDate = "2013-12-02",
        synopsis = "Follows the misadventures of an alcoholic scientist Rick and his overly nervous grandson Morty, " +
                "who split their time between domestic family life and intergalactic travel. Often finding themselves " +
                "in a heap of trouble that more often than not is created through their own actions.",
        genre = "Adventure, Animation, Comedy, Science Fiction",
        actors = listOf("Ian Cardoni", "Harry Belden", "Chris Parnell")
    )

    // Add media (TV series) to Database (db)
    db.addMedia(wednesday)
    db.addMedia(rickandmorty)

    //try to add episode for non-existing season to 'wednesday'
    println("Execute: Adding episode for non-existing season to 'Wednesday'")
    wednesday.addEpisode(1,
        Episode("Wednesday's Child is Full of Woe",
            1,
            59))

    println("\nPress Enter to continue...")
    readLine()  // waits until the user presses Enter

    // Add season 1 and season 2 to 'wednesday'
    println("Execute: Adding Season 1 and Season 2 to 'Wednesday")
    wednesday.addSeason(1)
    wednesday.addSeason(2)

    //add episodes to 'wednesday'
    println("Execute: Adding Episodes to 'Wednesday'")
    wednesday.addEpisode(1,
        Episode("Wednesday's Child is Full of Woe",
            1,
            59))

    wednesday.addEpisode(1,
        Episode("Woe is the Loneliest Number",
            2,
            49))

    wednesday.addEpisode(2,
        Episode("Here We Woe Again",
            1,
            60))

    // Add season 1 to 'rickandmorty'
    println("Execute: Adding season and episoded to 'Rick and Morty'")
    rickandmorty.addSeason(1)

    // Add episodes to 'rickandmorty'
    rickandmorty.addEpisode(1,
        Episode("Pilot",
            1,
            22))

    rickandmorty.addEpisode(1,
        Episode("Anatomy Park",
            3,
            22))

    rickandmorty.addEpisode(1,
        Episode("Lawnmower Dog",
            2,
            22))

    rickandmorty.addEpisode(1,
        Episode("M. Night Shaym-Aliens!",
            4,
            22))

    // Add season to 'rickandmorty' that already exists
    println("Execute: Attempting to add existing season to 'Rick and Morty'")
    rickandmorty.addSeason(1)

    //Create user(s)
    println("Execute: Creating a user.")
    val user = User("Soeren")

    //Show user's list of favourites (empty)
    println("Execute: Printing user's favourite list (which should be empty)")
    user.showFavourites()

    //Add media to user's list of favourites
    println("Execute: Adding media to user's favourite list")
    user.addFavorite(bladerunner)
    user.addFavorite(wednesday)

    //Show user's list of favourites (not empty)
    println("Execute: Printing user's favourite list (now populated)")
    user.showFavourites()

    //Remove media from user's list of favourites
    println("Execute: Removing a title from user's favourite list")
    user.removeFavorite(wednesday)

    //Show user's list of favourites with one item removed
    println("Execute: Showing updated favourite list")
    user.showFavourites()

    //Add existing media to user's list of favourites (should fail gracefully)
    println("Execute: Adding title to favourite's list that's already there. ")
    user.addFavorite(bladerunner)

    //Show all titles currently in the database
    println("Execute: Showing all media titles currently in database")
    db.listAllTitles()

    // List episodes in Season 1 of 'rickandmorty'
    println("Execute: Printing all episodes in season 1 of 'Rick and Morty'")
    rickandmorty.listEpisodes(1)

    // List episodes in non-existing Season 2 of 'rickandmorty'
    println("Execute: Attempting to print episodes in a non-existing season of 'Rick and Morty'")
    rickandmorty.listEpisodes(2)

    //Initialise search parameter for actor and title
    var actorName = ""
    var mediaTitle = ""

    //Search for Movie or TV series by name
    println("Execute: Searching for any media title containing 'ick'")

    mediaTitle = "ick"
    var foundMovies = db.searchByTitle(mediaTitle)
    //Take the foundMovies Media list returned from the search function.
    //Use the kotlin built-in collection function .map to transform the list:
    //For each Media object (it) in foundMovies, take its .title, then return a new list of just titles
    //println("Media found with $mediaTitle: ${foundMovies.map { it.title }}")
    if (foundMovies.isEmpty()) {
        println("No Media found with $mediaTitle")
    } else {
        println("Media found with $mediaTitle: ${foundMovies.map { it.title }}")
    }

    // Cleaner code with the printing result moved to the MovieDB Class
    println("Execute: Searching for any media title containing 'Raiders'")
    mediaTitle = "Raiders"
    db.printSearchByTitle(mediaTitle)

    //Run search without results; rerun with results

    println("Execute: Searching for any media title with Leonardo DiCaprio - no result should be found")
    actorName = "Leonardo DiCaprio"
    db.printSearchByActor(actorName)

    println("Execute: Searching for any media title with Harrison Ford")
    actorName = "Harrison Ford"
    db.printSearchByActor(actorName)

    println("Execute: Searching for any media title with Vin Diesel")
    actorName = "Vin Diesel"
    db.printSearchByActor(actorName)

    println("Execute: Searching for any media title with Jenny Ortega")
    actorName = "Jenny Ortega"
    db.printSearchByActor(actorName)

    //Show all titles currently in the database sorted alphabetically
    println("Execute: Showing all media titles currently in database (sorted alphabetically)")
    db.listAllMediaAlphabetically()

    //Print details for movie title
    println("Execute: Print Details for Blade Runner (Movie)")
    bladerunner.printDetails()

    //Print details for TV Series
    println("Execute: Print Details for Wednesday (TV Series)")
    wednesday.printDetails()


    //list all movies/tv series actor has acted in.

    //Update user rating of movie/TV series
}
