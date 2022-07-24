package it.univaq.disim.sose.application.models;

import java.util.ArrayList;
import java.util.List;

public class ReviewList {

    private ArrayList<Review> list;

    public ReviewList(){
        this.list = new ArrayList<>();
    }

    public ReviewList(ArrayList<Review> reviewList){
        this.list = reviewList;
    }

    public void add(Review review){
        list.add(review);
    }

    public ArrayList<Review> getList() {
        return this.list;
    }
}
