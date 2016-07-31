package com.vn.beta.easyplaces.views.models;

/**
 * Created by quang.td95 on 7/27/2016.
 */
public class Hotel {
    private String name;
    private String address;

    /*type:
     *dãy trọ/ nhà nguyên căn
     */

    private String type;
    private String area;
    private String price;
    private String link;


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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public Hotel(String name, String address, String type, String area, String price, String link) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.area = area;
        this.price = price;
        this.link=link;

    }

    public Hotel() {

    }

}
