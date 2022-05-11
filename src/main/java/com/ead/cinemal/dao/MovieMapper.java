package com.ead.cinemal.dao;

import com.ead.cinemal.model.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();

        movie.setId(rs.getInt("id"));
        movie.setName(rs.getString("name"));
        movie.setGenre(rs.getString("genre"));
        movie.setReleaseDate(rs.getDate("release_date"));
        movie.setAgeLimit(rs.getString("age_limit"));
        movie.setRating(rs.getInt("rating"));
        movie.setShortDescription(rs.getString("short_description"));
        movie.setDescription(rs.getString("description"));
        movie.setDuration(rs.getString("duration"));

        String[] timetable = rs.getString("timetable").split(",");
        movie.setTimetable(timetable);
        movie.setYoutubeRef(rs.getString("youtube_ref"));
        movie.setDirectorName(rs.getString("director"));

        String[] starring = rs.getString("staring").split(",");
        movie.setStarring(starring);
        movie.setImage((rs.getString("image")));
        movie.setIsItNew(rs.getString("is_it_new"));

        return movie;
    }
}
