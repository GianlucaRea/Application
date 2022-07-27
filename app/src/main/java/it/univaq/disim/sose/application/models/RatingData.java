package it.univaq.disim.sose.application.models;

import org.json.JSONObject;
import org.ksoap2.serialization.SoapObject;

public class RatingData {
    // Keys
    private String filmId;
    private String userId;

    // Parameters
    private String filmDirectionRating;
    private String actorsRating;
    private String globalScoreRating;
    private String dialoguesRating;
    private String costumerRating;
    private String globalScore;
    private String numberRatings;

    public RatingData() {
        super();
        this.filmId = "0";
        this.userId = "0";
        this.filmDirectionRating = "0";
        this.actorsRating = "0";
        this.globalScoreRating = "0";
        this.dialoguesRating = "0";
        this.costumerRating = "0";
        this.globalScore="0";
        this.numberRatings="0";
    }

    public RatingData(String filmId, String userId, String filmDirectionRating, String actorsRating, String globalScoreRating,
                      String dialoguesRating, String costumerRating,String globalScore,String numberRatings) {
        super();
        this.filmId = filmId;
        this.userId = userId;
        this.filmDirectionRating = filmDirectionRating;
        this.actorsRating = actorsRating;
        this.globalScoreRating = globalScoreRating;
        this.dialoguesRating = dialoguesRating;
        this.costumerRating = costumerRating;
        this.globalScore=globalScore;
        this.numberRatings=numberRatings;
    }

    public RatingData(SoapObject object){
        super();
        this.filmId = object.getPropertyAsString("filmId");
        this.userId = object.getPropertyAsString("userId");
        this.filmDirectionRating = object.getPropertyAsString("filmDirectionRating");
        this.actorsRating = object.getPropertyAsString("actorsRating");
        this.globalScoreRating = object.getPropertyAsString("globalScoreRating");
        this.dialoguesRating = object.getPropertyAsString("dialoguesRating");
        this.costumerRating = object.getPropertyAsString("costumerRating");
        this.numberRatings = object.getPropertyAsString("numberOfRatings");
        this.globalScore = object.getPropertyAsString("globalScore");
    }

    public String getFilmId() {
        return filmId;
    }


    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getFilmDirectionRating() {
        return filmDirectionRating;
    }


    public void setFilmDirectionRating(String filmDirectionRating) {
        this.filmDirectionRating = filmDirectionRating;
    }


    public String getActorsRating() {
        return actorsRating;
    }


    public void setActorsRating(String actorsRating) {
        this.actorsRating = actorsRating;
    }


    public String getGlobalScoreRating() {
        return globalScoreRating;
    }


    public void setGlobalScoreRating(String globalScoreRating) {
        this.globalScoreRating = globalScoreRating;
    }


    public String getDialoguesRating() {
        return dialoguesRating;
    }


    public void setDialoguesRating(String dialoguesRating) {
        this.dialoguesRating = dialoguesRating;
    }


    public String getCostumerRating() {
        return costumerRating;
    }


    public void setCostumerRating(String costumerRating) {
        this.costumerRating = costumerRating;
    }


    public String getGlobalScore() {
        return globalScore;
    }

    public void setGlobalScore(String globalScore) {
        this.globalScore = globalScore;
    }

    public String getNumberRatings() {
        return numberRatings;
    }

    public void setNumberRatings(String numberRatings) {
        this.numberRatings = numberRatings;
    }

    @Override
    public String toString() {
        return "filmDirectionRating: " + filmDirectionRating + "\nactorsRating: " + actorsRating  + "\ndialoguesRating: "
                + dialoguesRating + "\ncostumerRating: " + costumerRating + "\nglobalScoreRating: " + globalScoreRating
                + "\nnumber of Ratings: " + numberRatings;
    }

    public String globalScoreText(){
        return "This film has a globalscore of " + globalScore;
    }
}
