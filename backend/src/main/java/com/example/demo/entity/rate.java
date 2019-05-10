package com.example.demo.entity;

import java.util.ArrayList;

public class rate {
    private String average;
    private String rating_people;
    private ArrayList<String> stars;

    public rate(String average, String rating_people, ArrayList<String> stars) {
        this.average = average;
        this.rating_people = rating_people;
        this.stars = stars;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getRating_people() {
        return rating_people;
    }

    public void setRating_people(String rating_people) {
        this.rating_people = rating_people;
    }

    public ArrayList<String> getStars() {
        return stars;
    }

    public void setStars(ArrayList<String> stars) {
        this.stars = stars;
    }
}
