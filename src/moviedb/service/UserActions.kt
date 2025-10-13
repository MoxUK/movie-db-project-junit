package moviedb.service

import moviedb.entities.Media

interface UserActions {
    fun addFavorite(media: Media)
    fun removeFavorite(media: Media)
    fun showFavourites()
}
