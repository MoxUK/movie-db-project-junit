package main.moviedb.service

import main.moviedb.entities.Media

interface UserActions {
    fun addFavorite(media: Media)
    fun removeFavorite(media: Media)
    fun showFavourites()
    fun printUserDetails()
    fun rateMedia(media: Media, rating: Int)
    //fun rateMedia()
}
