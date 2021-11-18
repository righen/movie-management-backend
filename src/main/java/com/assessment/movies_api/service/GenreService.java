package com.assessment.movies_api.service;

import com.assessment.movies_api.model.Genre;
import com.assessment.movies_api.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(long genreId){
        return genreRepository.findById(genreId);
    }
}
