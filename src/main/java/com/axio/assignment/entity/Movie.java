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
    @GeneratedValue
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "rating")
    private double rating;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "comment")
    private String comment;

    @Column(name = "post_office_branch_name")
    private String postOfficeBranchName;

}
