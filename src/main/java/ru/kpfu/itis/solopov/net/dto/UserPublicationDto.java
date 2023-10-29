package ru.kpfu.itis.solopov.net.dto;

public class UserPublicationDto {
    private long id;
    private long userID;
    private long publicationID;

    public UserPublicationDto(long id, long userID, long publicationID) {
        this.id = id;
        this.userID = userID;
        this.publicationID = publicationID;
    }

    public UserPublicationDto(long userID, long publicationID) {
        this.userID = userID;
        this.publicationID = publicationID;
    }

    public long getId() {
        return id;
    }

    public long getUserID() {
        return userID;
    }

    public long getPublicationID() {
        return publicationID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setPublicationID(long publicationID) {
        this.publicationID = publicationID;
    }
}
