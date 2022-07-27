package it.univaq.disim.sose.application.models;

public class User {

    private String  userID;
    private String username;
    private String password;
    private String token;



    public User( String userID,String username,String password, String token) {
        super();

        this.userID = userID;
        this.username = username;
        this.password = password;
        this.token = token;

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
