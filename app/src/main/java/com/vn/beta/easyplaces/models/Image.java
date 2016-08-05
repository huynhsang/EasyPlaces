package com.vn.beta.easyplaces.models;


import android.graphics.Bitmap;

public class Image {

    private int id, ownerId;
    private Bitmap imgBitmap;

    public Image(){};

    public Image(int id, Bitmap imgBitmap, int ownerId){
        this.id = id;
        this.imgBitmap = imgBitmap;
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Bitmap getImgBitmap() {
        return imgBitmap;
    }

    public void setImgBitmap(Bitmap url) {
        this.imgBitmap = url;
    }
}
