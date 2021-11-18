package com.assessment.movies_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "releaseDate")
    private Date releaseDate;

    @Column(name = "summary")
    private String summary;

    @Column(name = "genreString")
    private String genreString;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Genre_Movies",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    private List<Genre> genres = new ArrayList<>();

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", summary=" + summary + "]";
    }
}
