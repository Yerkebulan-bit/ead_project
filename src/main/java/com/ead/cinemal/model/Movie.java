package com.ead.cinemal.model;

import java.util.Date;

public class Movie {

    private int id;
    private String name;
    private String genre;
    private Date releaseDate;
    private String ageLimit;
    private int rating;
    private String shortDescription;
    private String description;
    private String duration;
    private String[] timetable;
    private String youtubeRef;
    private String directorName;
    private String[] starring;
    private String image;
    private String isItNew;

    public Movie(){

    }


    public Movie(int id, String name, String genre, Date releaseDate, String ageLimit,
                 int rating, String shortDescription, String description, String duration,
                 String[] timetable, String youtubeRef, String directorName, String[] starring,
                 String image, String isItNew) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.ageLimit = ageLimit;
        this.rating = rating;
        this.shortDescription = shortDescription;
        this.description = description;
        this.duration = duration;
        this.timetable = timetable;
        this.youtubeRef = youtubeRef;
        this.directorName = directorName;
        this.starring = starring;
        this.image = image;
        this.isItNew = isItNew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String[] getTimetable() {
        return timetable;
    }

    public void setTimetable(String[] timetable) {
        this.timetable = timetable;
    }

    public String getYoutubeRef() {
        return youtubeRef;
    }

    public void setYoutubeRef(String youtubeRef) {
        this.youtubeRef = youtubeRef;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String[] getStarring() {
        return starring;
    }

    public void setStarring(String[] starring) {
        this.starring = starring;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsItNew() {
        return isItNew;
    }

    public void setIsItNew(String isItNew) {
        this.isItNew = isItNew;
    }

    public String timetableToString(){
        String timetableStr = "";
        if (timetable != null) {
            for (String time : timetable) {
                timetableStr += time;
                timetableStr += ",";
            }
            return timetableStr.substring(0, timetableStr.length() - 1);
        }
        return timetableStr;
    }

    public String starringToString(){
        String starringStr = "";
        if(starring != null) {
            for (String star : starring) {
                starringStr += star;
                starringStr += ",";
            }
            return starringStr.substring(0, starringStr.length() - 1);
        }
        return starringStr;
    }
}
