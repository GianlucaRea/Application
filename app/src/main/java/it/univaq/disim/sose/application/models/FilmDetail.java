package it.univaq.disim.sose.application.models;

import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.List;

public class FilmDetail {
    // IMDB Data
    private String id;
    private String title;
    private String originalTitle;
    private String fullTitle;
    private String imageLink;
    private String description;
    private String type;
    private String year;
    private String releaseDate;
    private String stars;
    private String awards;
    private String genres;
    private String companies;
    private String countries;
    private String languages;

    // Reviews
    // model review
    private ArrayList<Review> reviews;

    // Ranking
    // model rating
    private RatingData ratings;

    public FilmDetail() {
        super();
    }

    public FilmDetail(SoapObject soapObject, ArrayList<Review> reviews, RatingData ratings){
        super();
        this.id = soapObject.getPropertyAsString("id");
        this.title = soapObject.getPropertyAsString("title");
        this.originalTitle = soapObject.getPropertyAsString("originalTitle");
        this.fullTitle = soapObject.getPropertyAsString("fullTitle");
        this.imageLink = soapObject.getPropertyAsString("imageLink");
        this.description = soapObject.getPropertyAsString("description");
        this.type = soapObject.getPropertyAsString("type");
        this.year = soapObject.getPropertyAsString("year");
        this.releaseDate = soapObject.getPropertyAsString("releaseDate");
        this.stars = soapObject.getPropertyAsString("stars");
        this.awards = soapObject.getPropertyAsString("awards");
        this.genres = soapObject.getPropertyAsString("genres");
        this.companies = soapObject.getPropertyAsString("companies");
        this.countries = soapObject.getPropertyAsString("countries");
        this.languages = soapObject.getPropertyAsString("languages");

        this.ratings = ratings;
        this.reviews = reviews;
    }

    public FilmDetail(SoapObject soapObject){
        super();
        this.id = soapObject.getPropertyAsString("id");
        this.title = soapObject.getPropertyAsString("title");
        this.originalTitle = soapObject.getPropertyAsString("originalTitle");
        this.fullTitle = soapObject.getPropertyAsString("fullTitle");
        this.imageLink = soapObject.getPropertyAsString("imageLink");
        this.description = soapObject.getPropertyAsString("description");
        this.type = soapObject.getPropertyAsString("type");
        this.year = soapObject.getPropertyAsString("year");
        this.releaseDate = soapObject.getPropertyAsString("releaseDate");
        this.stars = soapObject.getPropertyAsString("stars");
        this.awards = soapObject.getPropertyAsString("awards");
        this.genres = soapObject.getPropertyAsString("genres");
        this.companies = soapObject.getPropertyAsString("companies");
        this.countries = soapObject.getPropertyAsString("countries");
        this.languages = soapObject.getPropertyAsString("languages");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getCompanies() {
        return companies;
    }

    public void setCompanies(String companies) {
        this.companies = companies;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }



    public RatingData getRatings() {
        return ratings;
    }

    public void setRatings(RatingData ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "FilmData [id=" + id + ", title=" + title + ", originalTitle=" + originalTitle + ", fullTitle="
                + fullTitle + ", imageLink=" + imageLink + ", description=" + description + ", type=" + type + ", year="
                + year + ", releaseDate=" + releaseDate + ", stars=" + stars + ", awards=" + awards + ", genres="
                + genres + ", companies=" + companies + ", countries=" + countries + ", languages=" + languages
                + ", reviews=" + reviews + ", ratings=" + ratings + "]";
    }

    public String descriptionForDetails(){
        return  description + "("+genres +")" + " The released in " + year + " produced in " + countries + " by " + companies+". "+ "The "
                + fullTitle + " has  " + awards + "." + " Cast: " + stars + ". " + "Available in " + languages;

    }

}
