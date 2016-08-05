package com.vn.beta.easyplaces.databases;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import com.vn.beta.easyplaces.models.Image;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TbImage extends DatabaseHelper{

    private static final String TB_NAME = "IMAGE";

    public TbImage(Context context) {
        super(context);
    }

    public Image getImageById(int id){
        Image image = null;
        Cursor cursor = this.selectQuery(TB_NAME, id);
        byte[] imgByte = cursor.getBlob(1);
        Bitmap imgBitmap = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        image = new Image(cursor.getInt(0), imgBitmap, cursor.getInt(2));
        cursor.close();
        return image;
    }


    public List<Image> getImagesByOwner(int ownerID){
        Image image = null;
        List<Image> imageListOwner = new ArrayList<>();
        String whereOwner = "IdCustomer=" + ownerID;
        Cursor cursor = this.QUERY_SELECT_OWNER(TB_NAME, whereOwner);
        byte[] imgByte = null;
        Bitmap imgBitmap = null;
        while (!cursor.isAfterLast()){
            imgByte = cursor.getBlob(1);
            imgBitmap = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
            image = new Image(cursor.getInt(0), imgBitmap, cursor.getInt(2));
            imageListOwner.add(image);
            cursor.moveToNext();
        }
        cursor.close();
        return imageListOwner;
    }

    public List<Image> getAllImages(){
        Image image = null;
        List<Image> imageList = new ArrayList<>();
        Cursor cursor = this.QUERY_SELECT_ALL(TB_NAME);
        byte[] imgByte = null;
        Bitmap imgBitmap = null;
        while (!cursor.isAfterLast()){
            imgByte = cursor.getBlob(1);
            imgBitmap = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
            image = new Image(cursor.getInt(0), imgBitmap, cursor.getInt(2));
            imageList.add(image);
            cursor.moveToNext();
        }
        cursor.close();
        return imageList;
    }

    public long UpdateImage(Image image){
        ContentValues contentValues = new ContentValues();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.getImgBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        contentValues.put("imgByte", byteArray);
        contentValues.put("ownerId", image.getOwnerId());

        String[] whereArgs = {Integer.toString(image.getId())};
        String whereClause = "id=?";
        return this.UPDATE_TABLE(TB_NAME, contentValues, whereClause, whereArgs);
    }

    public long addImage(Image image){
        ContentValues contentValues = new ContentValues();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.getImgBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        contentValues.put("id", image.getId());
        contentValues.put("imgByte", byteArray);
        contentValues.put("ownerId", image.getOwnerId());
        return this.INSERT_TABLE(TB_NAME, contentValues);
    }

    public boolean deleteImageById(int id){
        String whereClause = "id=?";
        String[] whereArgs = {Integer.toString(id)};
        return this.DELETE_TABLE(TB_NAME, whereClause, whereArgs);
    }

}
