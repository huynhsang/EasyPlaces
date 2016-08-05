package com.vn.beta.easyplaces.databases;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.vn.beta.easyplaces.models.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TbPost extends DatabaseHelper{

    private static final String TB_NAME = "POST";

    public TbPost(Context context) {
        super(context);
    }

    public Post getPostById(int id){
        Post post = null;
        Cursor cursor = this.selectQuery(TB_NAME, id);
        post = new Post(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getFloat(4),
                cursor.getInt(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10));
        cursor.close();
        return post;
    }

    public List<Post> getAllPost(){
        Post post = null;
        List<Post> postList = new ArrayList<>();
        Cursor cursor = this.QUERY_SELECT_ALL(TB_NAME);
        while (!cursor.isAfterLast()){
            post = new Post(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getFloat(4),
                    cursor.getInt(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10));
            postList.add(post);
            cursor.moveToNext();
        }
        cursor.close();
        return postList;
    }

    public List<Post> getPostByZone(String zone){
        Post post = null;
        List<Post> postList = new ArrayList<>();
        String whereOwner = "zone=" + zone;
        Cursor cursor = this.QUERY_SELECT_OWNER(TB_NAME, whereOwner);
        while (!cursor.isAfterLast()){
            post = new Post(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getFloat(4),
                    cursor.getInt(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getInt(10));
            postList.add(post);
            cursor.moveToNext();
        }
        cursor.close();
        return postList;
    }

    public long updatePost(Post post){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", post.getName());
        contentValues.put("address", post.getAddress());
        contentValues.put("type", post.getType());
        contentValues.put("area", post.getArea());
        contentValues.put("price", post.getPrice());
        contentValues.put("longitude", post.getLongitude());
        contentValues.put("latitude", post.getLatitude());
        contentValues.put("dateTime", post.getDateTime());
        contentValues.put("zone", post.getZone());
        String[] whereArgs = {Integer.toString(post.getId())};
        String whereClause = "ID=?";
        long returnValue = this.UPDATE_TABLE(TB_NAME, contentValues, whereClause, whereArgs);
        return returnValue;
    }

    public long addPost(Post post){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", post.getId());
        contentValues.put("name", post.getName());
        contentValues.put("address", post.getAddress());
        contentValues.put("type", post.getType());
        contentValues.put("area", post.getArea());
        contentValues.put("price", post.getPrice());
        contentValues.put("longitude", post.getLongitude());
        contentValues.put("latitude", post.getLatitude());
        contentValues.put("dateTime", post.getDateTime());
        contentValues.put("zone", post.getZone());
        long returnValue = this.INSERT_TABLE(TB_NAME, contentValues);
        return returnValue;
    }


    public boolean deletePostById(int id){
        String whereClause = "id=?";
        String[] whereArgs = {String.valueOf(id)};
        return this.DELETE_TABLE(TB_NAME, whereClause, whereArgs);
    }
}
