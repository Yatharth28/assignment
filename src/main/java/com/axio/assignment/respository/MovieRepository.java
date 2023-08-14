package com.axio.assignment.respository;

import com.axio.assignment.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findByMovieName(String movieName);

    List<Movie> findAllByPinCode(String pinCode);
}
