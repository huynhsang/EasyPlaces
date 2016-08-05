package com.vn.beta.easyplaces.models;


public class Post {

    private int id, price, ownerId;
    private String name, address, type, longitude, latitude, dateTime, zone;
    private float area;

    private String link;

    public Post(int id, String name, String address, String type, float area, int price, String longitude, String latitude,
                String dateTime, String zone, int ownerId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.area = area;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dateTime = dateTime;
        this.zone = zone;
        this.ownerId = ownerId;
    }

    public Post(String name, String address, String type, float area, int price, String link){
        this.name = name;
        this.address = address;
        this.type = type;
        this.price = price;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
