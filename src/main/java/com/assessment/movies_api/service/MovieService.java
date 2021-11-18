package com.assessment.movies_api.service;

import com.assessment.movies_api.model.Movie;
import com.assessment.movies_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies() {

        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByGenreName(String Name) {
        return movieRepository.findByGenresName(Name);

    }
}
