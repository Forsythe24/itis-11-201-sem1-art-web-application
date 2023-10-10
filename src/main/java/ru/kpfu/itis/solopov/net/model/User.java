package ru.kpfu.itis.solopov.net.model;


import java.time.LocalDate;
import java.util.Date;

public class User {

//    private int id;

    private String username;


    private String email;

    private String login;

    private String password;
    private String gender;
    private LocalDate birthDate;
    private Long id;

    public User(String username, String email, String gender, String login, String password, LocalDate birthDate, Long id) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.id = id;
    }

    public User(String username, String email, String gender, String login, String password, LocalDate birthDate) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

//    public User(int id, String username, String email, String gender, String login, String password) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.gender = gender;
//        this.login = login;
//        this.password = password;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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
}
