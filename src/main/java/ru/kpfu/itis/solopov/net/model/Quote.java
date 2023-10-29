package ru.kpfu.itis.solopov.net.model;

public class Quote {
    private String text;
    private String author;
    private long id;

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public Quote(String text, String author, long id) {
        this.text = text;
        this.author = author;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public long getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(long id) {
        this.id = id;
    }
}
