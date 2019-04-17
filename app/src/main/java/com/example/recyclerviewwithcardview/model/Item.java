package com.example.recyclerviewwithcardview.model;

public class Item {
    private String date,time,stadium;
    private String leftImgURL,rightImgURL;
    private String teamOne,teamTwo;

    public Item(String date, String time, String stadium, String leftImgURL, String rightImgURL, String teamOne, String teamTwo) {
        this.date = date;
        this.time = time;
        this.stadium = stadium;
        this.leftImgURL = leftImgURL;
        this.rightImgURL = rightImgURL;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStadium() {
        return stadium;
    }

    public String getLeftImgURL() {
        return leftImgURL;
    }

    public String getRightImgURL() {
        return rightImgURL;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }
}
