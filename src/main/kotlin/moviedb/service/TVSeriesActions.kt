package main.moviedb.service

import main.moviedb.entities.Episode

interface TVSeriesActions {
    fun addSeason(seasonNumber: Int)
    fun addEpisode(seasonNumber: Int, episode: Episode)
    fun listEpisodes(seasonNumber: Int)
    fun printDetails()
}