package moviedb.service
import moviedb.entity.Media

//Generic MovieDB interface actions

interface MovieDatabase {
    fun addMedia(media: Media)
    fun searchByTitle(searchTitle: String): List<Media>
    fun searchByActor(searchActor: String): List<Media>
    fun updateRating(media: Media, rating: Double)
    fun listAllTitles()
    fun printSearchByTitle(searchTitle: String)
    fun printSearchByActor(searchActor: String)
    fun listAllMediaAlphabetically()
}
