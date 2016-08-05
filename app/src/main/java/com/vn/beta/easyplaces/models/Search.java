package com.vn.beta.easyplaces.models;


public class Search {

    private int id, maxPrice, ownerId;
    private String zone, type, object, dateTime;
    private float minArea;

    public Search(){}

    public Search(int id, String zone, float minArea, int maxPrice, String type, String object, String dateTime, int ownerId){
        this.id = id;
        this.zone = zone;
        this.minArea = minArea;
        this.maxPrice = maxPrice;
        this.type = type;
        this.object = object;
        this.dateTime = dateTime;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public float getMinArea() {
        return minArea;
    }

    public void setMinArea(float minArea) {
        this.minArea = minArea;
    }
}
