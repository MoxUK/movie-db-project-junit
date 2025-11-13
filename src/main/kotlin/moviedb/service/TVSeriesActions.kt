package moviedb.service

import moviedb.entity.Episode

interface TVSeriesActions {
    fun addSeason(seasonNumber: Int)
    fun addEpisode(seasonNumber: Int, episode: Episode)
    fun listEpisodes(seasonNumber: Int)
    fun printDetails()
}