package com.ead.cinemal.dao;

import com.ead.cinemal.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getAllMovies(){
        return jdbcTemplate.query("SELECT * FROM Movie", new MovieMapper());
    }

    public List<Movie> getMoviesByWildCard(String pattern){
        return jdbcTemplate.query("SELECT * FROM Movie WHERE name LIKE ?",
                new Object[]{pattern + "%"}, new MovieMapper());
    }

    public Movie getMovieById(int id){
        return jdbcTemplate.query("SELECT * FROM Movie WHERE id = ?", new Object[]{id},
                new MovieMapper()).stream().findAny().orElse(null);
    }

    public void addNewMovie(Movie movie){
        jdbcTemplate.update("INSERT INTO movie(name, genre, release_date, age_limit, rating, " +
                "short_description, description, duration, timetable, youtube_ref, director, " +
                "staring, image, is_it_new) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,?, ?)", movie.getName(), movie.getGenre(),
                movie.getReleaseDate(), movie.getAgeLimit(), movie.getRating(), movie.getShortDescription(),
                movie.getDescription(), movie.getDuration(), movie.timetableToString(), movie.getYoutubeRef(),
                movie.getDirectorName(), movie.starringToString(), "/img/blank.jpg", movie.getIsItNew());
    }

    public void deleteById(int id){
        jdbcTemplate.update("DELETE FROM Movie WHERE id = ?", id);
    }

    public void update(Movie movie, int id){
        jdbcTemplate.update("UPDATE Movie SET name = ?, genre = ?, release_date = ?, age_limit = ?, rating = ?," +
                "short_description = ?, description = ?, duration = ?, timetable = ?, youtube_ref = ?, director = ?, " +
                "staring = ?, image = ?, is_it_new =? WHERE id = ?", movie.getName(), movie.getGenre(),
                movie.getReleaseDate(), movie.getAgeLimit(), movie.getRating(), movie.getShortDescription(),
                movie.getDescription(), movie.getDuration(), movie.timetableToString(), movie.getYoutubeRef(),
                movie.getDirectorName(), movie.starringToString(), movie.getImage(), movie.getIsItNew(), id);
    }

}
