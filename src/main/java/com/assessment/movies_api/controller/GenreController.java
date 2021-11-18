package com.assessment.movies_api.controller;

import com.assessment.movies_api.model.Genre;
import com.assessment.movies_api.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public List<Genre> getAllGenres(){
        return genreService.getGenres();
    }

    @PostMapping("/genres")
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){
        return new ResponseEntity<Genre>(genreService.saveGenre(genre), HttpStatus.CREATED);
    }
}
