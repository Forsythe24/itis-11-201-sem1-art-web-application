package ru.kpfu.itis.solopov.net.dto;

import java.time.LocalDate;
import java.util.Date;

public class UserDto {
    private String username;
    private String email;
    private String gender;
    private String login;
    private String password;
    private LocalDate birthDate;
    private Long id;
    private String genre;

    public UserDto(String username, String email, String gender, String login, String password, LocalDate birthDate, String genre) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.genre = genre;
    }

    public UserDto(String username, String email, String gender, String login, String password, LocalDate birthDate, String genre, Long id) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.id = id;
        this.genre = genre;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
