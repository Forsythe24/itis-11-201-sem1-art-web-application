package ru.kpfu.itis.solopov.net.dto;


public class QuoteDto {
    private String text;
    private String author;
    private long id;

    public QuoteDto(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public QuoteDto(String text, String author, long id) {
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

