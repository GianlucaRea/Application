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

    public RatingData() {
        super();
    }

    public RatingData(String filmId, String userId, String filmDirectionRating, String actorsRating, String globalScoreRating,
                      String dialoguesRating, String costumerRating) {
        super();
        this.filmId = filmId;
        this.userId = userId;
        this.filmDirectionRating = filmDirectionRating;
        this.actorsRating = actorsRating;
        this.globalScoreRating = globalScoreRating;
        this.dialoguesRating = dialoguesRating;
        this.costumerRating = costumerRating;
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


    @Override
    public String toString() {
        return "filmDirectionRating: " + filmDirectionRating + "\nactorsRating: " + actorsRating  + "\ndialoguesRating: "
                + dialoguesRating + "\ncostumerRating: " + costumerRating + "\nglobalScoreRating: " + globalScoreRating ;
    }
}
