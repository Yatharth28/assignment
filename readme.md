Basic functionalities:

1. Endpoint for user to submit ratings (between 1-10) for a selected movie (selection is done by movieId).
2. Endpoint to get the rating (between 1-10) of a selected movie, movie can be selected on these criteria:
    1. using the movie Id
    2. using the movie name
3. Endpoint to search for list of active movies in a pincode. This pincode is taken from external
   API. (http://www.postalpincode.in/Api-Details)

Enhancement points:

1. Database Integration - MySQL is integrated. A table name MOVIES_DETAILS is created with columns - movie_id,
   movie_name, pin_code, post_office_branch_name, comments, rating.
2. Comments field is added for each movie.
