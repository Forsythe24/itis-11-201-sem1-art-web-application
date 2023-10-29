package ru.kpfu.itis.solopov.net.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CommentDto {
    private long id;
    private long publID;
    private long userID;
    private String text;
    private LocalDate date;
    private LocalTime time;

    public CommentDto(long id, long publID, long userID, String text, LocalDate date, LocalTime time) {
        this.id = id;
        this.userID = userID;
        this.date = date;
        this.time = time;
        this.publID = publID;
        this.text = text;
    }

    public CommentDto(long publID, long userID, String text, LocalDate date, LocalTime time) {
        this.userID = userID;
        this.date = date;
        this.time = time;
        this.publID = publID;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public long getUserID() {
        return userID;
    }


    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
    public String getText() {
        return text;
    }

    public long getPublID() {
        return publID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPublID(long publID) {
        this.publID = publID;
    }
}


