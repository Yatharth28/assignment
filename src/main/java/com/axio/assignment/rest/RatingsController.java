package com.axio.assignment.rest;

import com.axio.assignment.entity.Movie;
import com.axio.assignment.service.MovieRatingServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RatingsController {

    @Autowired
    private MovieRatingServiceImpl movieRatingServiceImpl;

    private static final String PINCODE_API_URL = "https://api.postalpincode.in/pincode/";

    @PostMapping("movie/submitRating")
    public ResponseEntity<Movie> submitRating(@RequestBody Movie movieRating) {
        return new ResponseEntity<>(movieRatingServiceImpl.submitRating(movieRating), HttpStatus.CREATED);
    }

    @GetMapping("movie/findRatingById/{movieId}")
    public ResponseEntity<Movie> getRatingById(@PathVariable Integer movieId) {
        Movie rating = movieRatingServiceImpl.getRatingById(movieId);
        if (rating == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rating);
    }

    @GetMapping("movie/findRatingByName/{movieName}")
    public ResponseEntity<Movie> getRatingByName(@PathVariable String movieName) {
        Movie rating = movieRatingServiceImpl.getRatingByName(movieName);
        if (rating == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rating);
    }

    @GetMapping("movie/findAllActiveMovies/{pinCode}")
    public List<Movie> getActiveMovies(@PathVariable String pinCode) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String pincodeJson = restTemplate.getForObject(PINCODE_API_URL + pinCode, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(pincodeJson);
        String finalPincode = jsonNode.get(0).get("PostOffice").get(0).get("Pincode").asText();
        System.out.println(finalPincode);
        return movieRatingServiceImpl.getAllActiveMoviesByPinCode(pinCode);
    }
}
