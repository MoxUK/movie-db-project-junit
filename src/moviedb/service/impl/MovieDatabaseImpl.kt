package moviedb.service.impl

import moviedb.entities.Media
import moviedb.entities.Movie
import moviedb.entities.TVSeries
import moviedb.service.MovieDatabase

class MovieDatabaseImpl : MovieDatabase {
    private val mediaList: MutableList<Media> = mutableListOf()

    override fun addMedia(media: Media)  {
        //add media to the list of media (mediaList)
        mediaList.add(media)
    }

    override fun listAllTitles() {
        if (mediaList.isEmpty()) {
            println("The database is currently empty.")
        } else {
            println("Titles currently in database:")
            // print each object in the mediaList
            // old code:             mediaList.forEach {println("* ${it.title}")
            // new: post-fix output with TV or Movie identifier depending on media type
            mediaList.forEach {
                when (it) {
                    is Movie -> println("* ${it.title} (Movie)")
                    is TVSeries -> println("* ${it.title} (TV Series)")
                    else -> println("* ${it.title} (unknown media type)")
                }
            }
        }
    }

    override fun searchByActor(searchActor: String): List<Media> {
        // Create a list for results
        val matches = mutableListOf<Media>()
        // Loop through each Media object in Database
        // Match searchActor with Actor
        for (mediaFound in mediaList) {
            var found = false
            for (actor in mediaFound.actors) {
                if (actor.equals(searchActor, ignoreCase = true)) {
                    found = true
                    break
                }
            }
            // If match is found, add result mediaFound to matches list
            if (found) {
                matches.add(mediaFound)
            }
        }
        return matches
    }

    override fun printSearchByActor(actor: String) {
        val found = searchByActor(actor)
        if (found.isEmpty()) {
            println("No media found with $actor")
        } else {
            println("Media found with $actor: ${found.map { it.title }.joinToString(", ")}")
        }
    }

    //Logic from searchByActor optimised for searchByTitle using lambda function

    override fun searchByTitle(searchTitle: String): List<Media> {
        // Use built-in kotlin collection function 'filter' on list
        // step through each element on the mediaList and check if the search string is included in the title of the media, ignoring case
        // Lambda returns 'true' if matching.
        // Output of function is a list containing titles matching in the lambda
        return mediaList.filter { it.title.contains(searchTitle, ignoreCase = true) }
    }

    override fun printSearchByTitle(searchTitle: String) {
        val found = searchByTitle(searchTitle)
        if (found.isEmpty()) {
            println("No media found with $searchTitle")
        } else {
            println("Media found with $searchTitle: ${found.map { it.title }.joinToString(", ")}")
        }
    }

    override fun updateRating(media: Media, rating: Double) {
        //TODO: Check value of rating - should be 0<userRating=<10
        media.userRating = rating
        println("${media.title} rating updated to $rating")
    }

    override fun listAllMediaAlphabetically() {
        if (mediaList.isEmpty()) {
            println("The database is empty.")
        } else {
            println("All media in alphabetical order:")
            mediaList.sortedBy { it.title.lowercase() }   // sort list - ignore case
                .forEach {
                    when (it) {
                        is Movie -> println("${it.title} (Movie)")
                        is TVSeries -> println("${it.title} (TV Series)")
                        else -> println("${it.title} (Unknown Media Type)")
                    }
                }
        }
    }

}