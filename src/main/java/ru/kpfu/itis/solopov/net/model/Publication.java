package ru.kpfu.itis.solopov.net.model;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;

public class Publication {
    private long id;
    private long userID;
    private String title;
    private String text;
    private LocalDate date;
    private LocalTime time;
    private String genre;
    private String description;
    private String image;

    public Publication(long id, long userID, String title, String text, LocalDate date, LocalTime time, String genre, String description, String image) {
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.date = date;
        this.time = time;
        this.genre = genre;
        this.description = description;
        this.image = image;
        this.text = text;
    }

    public Publication(long userID, String title, String text, LocalDate date, LocalTime time, String genre, String description, String image) {
        this.userID = userID;
        this.title = title;
        this.date = date;
        this.time = time;
        this.genre = genre;
        this.description = description;
        this.image = image;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public long getUserID() {
        return userID;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }
}
