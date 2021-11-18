package com.assessment.movies_api.controller;

import com.assessment.movies_api.model.Movie;
import com.assessment.movies_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getMovies();
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        String s = new String();
        for (int i = 0; i < movie.getGenres().size(); i++) {
            System.out.println(movie.getGenres().get(i).getName());
            s = s.concat(' ' + movie.getGenres().get(i).getName() + ' ');
        }
        movie.setGenreString(s);
        return new ResponseEntity<Movie>(
                movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping("/movies/Genre/{name}")
    public List<Movie> getMoviesByGenres(@PathVariable String name) {
        return movieService.getMoviesByGenreName(name);
    }

}
