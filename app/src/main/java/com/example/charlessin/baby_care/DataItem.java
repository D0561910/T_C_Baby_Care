package com.example.charlessin.baby_care;

public class DataItem {

    private String name;
    private String shelter;
    private String bPX;
    private String bPY;
    private String bTel;

    DataItem(){
    }

    DataItem(int img , String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbPX() {
        return bPX;
    }

    public void setbPX(String bPX) {
        this.bPX = bPX;
    }

    public String getbPY() {
        return bPY;
    }

    public void setbPY(String bPY) {
        this.bPY = bPY;
    }

    public String getbTel() {
        return bTel;
    }

    public void setbTel(String bTel) {
        this.bTel = bTel;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }
}
