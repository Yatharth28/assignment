package com.axio.assignment.service;

import com.axio.assignment.entity.Movie;
import com.axio.assignment.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieRatingServiceImpl {

    @Autowired
    private MovieRepository movieRepository;

    public Movie submitRating(Movie rating) {
        return movieRepository.save(rating);
    }

    public Movie getRatingById(Integer movieId) {
        return movieRepository.findById(movieId).orElse(null);

    }

    public Movie getRatingByName(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }

    public List<Movie> getAllActiveMoviesByPinCode(String pinCode) {
        return movieRepository.findAllByPinCode(pinCode);
    }
}
