package moviedb.service

import moviedb.entities.Episode
import moviedb.entities.Season

interface TVSeriesActions {
    fun addSeason(seasonNumber: Int)
    fun addEpisode(seasonNumber: Int, episode: Episode)
    fun listEpisodes(seasonNumber: Int)
    fun printDetails()
}