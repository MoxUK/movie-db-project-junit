package moviedb.entities
//TVSeries class should include Title, Pilot Episode Premier date, Synopsis, Genre, Actors, User Rating
//Inherit Title, Synopsis, Genre and Actors from Media class

import moviedb.service.TVSeriesActions

class TVSeries(
    title: String,
    val pilotDate: String,
    synopsis: String,
    genre: String,
    actors: List<String>,
    userRating: Double = 0.0
) : Media(title, synopsis, genre, actors, userRating), TVSeriesActions {

    val seasons: MutableList<Season> = mutableListOf()

    override fun addSeason(seasonNumber: Int) {
        if (seasons.none { it.seasonNumber == seasonNumber }) {
            seasons.add(Season(seasonNumber))
            println("Season $seasonNumber added to $title")
        } else {
            println("Season $seasonNumber already exists for $title")
        }
    }

    override fun addEpisode(seasonNumber: Int, episode: Episode) {
        val season = seasons.find { it.seasonNumber == seasonNumber }
        if (season != null) {
            season.episodes.add(episode)
            season.episodes.sortBy { it.episodeNumber } // keep episodes sorted
            println("Episode '${episode.title}' added to $title Season $seasonNumber")
        } else {
            println("Season $seasonNumber not found for $title. Please add the season first.")
        }
    }

    override fun listEpisodes(seasonNumber: Int) {
        val season = seasons.find { it.seasonNumber == seasonNumber }
        if (season != null) {
            if (season.episodes.isEmpty()) {
                println("No episodes found in Season $seasonNumber of $title")
            } else {
                println("Episodes in $title Season $seasonNumber:")
                season.episodes.forEach {
                    println("Episode ${it.episodeNumber}: ${it.title} (${it.runtimeTVEpisode} min)")
                }
            }
        } else {
            println("Season $seasonNumber not found for $title")
        }
    }

    override fun printDetails() {
        println("=== TV Series Details ===")
        println("Title: $title")
        println("Pilot Episode Premier: $pilotDate")
        println("Genre: $genre")
        println("Actors: ${actors.joinToString(", ")}")
        println("Synopsis: $synopsis")
        println("User Rating: $userRating")
        println("=========================")
    }
}
