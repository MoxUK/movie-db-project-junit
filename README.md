# movie-db-project

<h2>Synopsis</h2>
Create a Media Database with basic functionality as described below.

Project should include Media as a class with Movie and TVSeries as subclasses plus a User class:
- Media class should be an abstract including common variable for Movies and TV Series:
  Title, Synopsis, Genre, Actors, User Rating
- Movie class should include ...
  Release Year, Runtime, Director, and inherit (Title), (Synopsis), (Genre), Actors) and (User Rating) from Media
- TVSeries class should include
  Pilot Episode Premier date, and inherit  (Title), (Synopsis), (Genre), (Actors) and (User Rating) from Media
    - TVSeries class should include additional sub-categories
        - Season with Season Number
        - Episode with Episode title, number and runtime
- User class including Username, UserId and Favorites (list)

<h3>Functionality to implement:</h3>
Movie & Tv Series:
- Add a Season to a TV series
    - check Season doesn't already exist
- Add an episode to a TV series season
    - Check if season doesn't exist
    - check episode doesn't already exist
    - Store episode in correct order
- Search for Movie or TV series by title
- Actor search: list all media titles actor has acted in.
- List all titles in the db
    - print distinction between Movie and TV series episode
- List all titles in the db (sorted alphabetically)
- List all episodes stored for a specific season
    - Check if season exists, if not then fail gracefully
- Print details about media title
- Media title now have user ratings based on average of all users' ratings


User:
- Add Movie/TV series to user's favourite list
    - Check if title is already on list
- Remove title from user's favourite list
- List all titles on a specific user's favourite list
- Assign unique UserId to each created user
- Update user rating of movie/TV series


<h3>Structure:</h3>

```
MovieDB/
├─ Entities
│  ├─ User
│  ├─ Media/
│  │  ├─ Movies/
│  │  └─ TV Series/
│  │     ├─ Season
│  │     └─ Episode
├─ Services/
│  ├─ Implementations/
│  │  └─ MovieDB Implementation
│  ├─ TV Series Actions (Interface)
│  └─ User Specific Actions (Interface)
```

<br>
TODO:
userRating should not be public mutable. Wrap in a setter with validation.

----

Add user reviews to each Media?
Each user can submit a review, but only one review per person:
If no review exists for user, then add review
If review exists for user, then warn of overwrite - confirm y/n:
y: overwrite existing review
n: keep existing review
                    
