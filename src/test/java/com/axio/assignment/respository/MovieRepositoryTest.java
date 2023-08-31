package com.axio.assignment.respository;

import com.axio.assignment.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void findByMovieName() {
        Movie testMovie = new Movie();
        testMovie.setMovieName("Dark Knight");
        testMovie.setComment("nolan is director");
        testMovie.setPostOfficeBranchName("HSR Layout");
        testMovie.setPinCode("560102");
        testMovie.setRating(7.5);
        movieRepository.save(testMovie);

        String movieTitle = "Dark Knight";
        Movie movieData = movieRepository.findByMovieName(movieTitle);

        assert movieData != null;
        assertEquals(movieData.getMovieName(), movieTitle);
        assertEquals(movieData.getRating(), 7.5);
        assertEquals(movieData.getMovieId(), 9);
    }
}