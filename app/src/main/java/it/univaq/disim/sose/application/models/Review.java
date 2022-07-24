package it.univaq.disim.sose.application.models;

public class Review {

    private String  filmID;
    private String userID;
    private String title;
    private String comment;


    public Review(String filmID, String userID,String title, String comment) {
        super();
        this.filmID = filmID;
        this.userID = userID;
        this.title = title;
        this.comment = comment;
    }


    public String getFilmID() {
        return filmID;
    }

    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Review [filmID=" + filmID + ", userID=" + userID + ", title=" + title + ", comment=" + comment + "]";
    }
}
