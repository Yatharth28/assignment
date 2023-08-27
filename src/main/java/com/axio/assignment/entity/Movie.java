package com.axio.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOVIE_DETAILS")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "rating", nullable = false)
    private double rating;

    @Column(name = "pin_code", nullable = false)
    private String pinCode;

    @Column(name = "comment")
    private String comment;

    @Column(name = "post_office_branch_name")
    private String postOfficeBranchName;

}
