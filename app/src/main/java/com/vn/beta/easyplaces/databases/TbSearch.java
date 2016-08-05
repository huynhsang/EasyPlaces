package com.vn.beta.easyplaces.databases;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.vn.beta.easyplaces.models.Search;

import java.util.ArrayList;
import java.util.List;

public class TbSearch extends DatabaseHelper{

    private static final String TB_NAME = "SEARCH";

    public TbSearch(Context context) {
        super(context);
    }

    public Search getSearchById(int id){
        Search search = null;
        Cursor cursor = this.selectQuery(TB_NAME, id);
        search = new Search(cursor.getInt(0), cursor.getString(1), cursor.getFloat(2), cursor.getInt(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6), cursor.getInt(7));
        cursor.close();
        return search;
    }


    public List<Search> getSearchsByOwner(int ownerID){
        Search search = null;
        List<Search> searchListOwner = new ArrayList<>();
        String whereOwner = "IdCustomer=" + ownerID;
        Cursor cursor = this.QUERY_SELECT_OWNER(TB_NAME, whereOwner);
        while (!cursor.isAfterLast()){
            search = new Search(cursor.getInt(0), cursor.getString(1), cursor.getFloat(2), cursor.getInt(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6), cursor.getInt(7));
            searchListOwner.add(search);
            cursor.moveToNext();
        }
        cursor.close();
        return searchListOwner;
    }

    public List<Search> getAllSearchs(){
        Search search = null;
        List<Search> searchList = new ArrayList<>();
        Cursor cursor = this.QUERY_SELECT_ALL(TB_NAME);
        while (!cursor.isAfterLast()){
            search = new Search(cursor.getInt(0), cursor.getString(1), cursor.getFloat(2), cursor.getInt(3), cursor.getString(4),
                    cursor.getString(5), cursor.getString(6), cursor.getInt(7));
            searchList.add(search);
            cursor.moveToNext();
        }
        cursor.close();
        return searchList;
    }

    public long UpdateSearch(Search search){
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", search.getZone());
        contentValues.put("minArea", search.getMinArea());
        contentValues.put("maxPrice", search.getMaxPrice());
        contentValues.put("type", search.getType());
        contentValues.put("object", search.getObject());
        contentValues.put("dateTime", search.getDateTime());
        contentValues.put("ownerId", search.getOwnerId());

        String[] whereArgs = {Integer.toString(search.getId())};
        String whereClause = "id=?";
        return this.UPDATE_TABLE(TB_NAME, contentValues, whereClause, whereArgs);
    }

    public long addSearch(Search search){

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", search.getId());
        contentValues.put("name", search.getZone());
        contentValues.put("minArea", search.getMinArea());
        contentValues.put("maxPrice", search.getMaxPrice());
        contentValues.put("type", search.getType());
        contentValues.put("object", search.getObject());
        contentValues.put("dateTime", search.getDateTime());
        contentValues.put("ownerId", search.getOwnerId());
        return this.INSERT_TABLE(TB_NAME, contentValues);
    }

    public boolean deleteSearchById(int id){
        String whereClause = "id=?";
        String[] whereArgs = {Integer.toString(id)};
        return this.DELETE_TABLE(TB_NAME, whereClause, whereArgs);
    }

}
