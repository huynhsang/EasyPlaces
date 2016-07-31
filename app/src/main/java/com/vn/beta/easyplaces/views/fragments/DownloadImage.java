package com.vn.beta.easyplaces.views.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DownloadImage extends AsyncTask<ArrayList<String>, Void, ArrayList<Bitmap>> {
    ProgressDialog progressDialog=null;
    ArrayList<Bitmap> bitmaps=new ArrayList<>();
    Context context;
    public DownloadImage(Context context){
        this.context=context;
    }
    @Override
    protected ArrayList<Bitmap> doInBackground(ArrayList<String>... params) {
        ArrayList<String> links = params[0];
        ArrayList<Bitmap> bitmaps=new ArrayList<>();
        for (int i = 0; i < links.size(); i++) {
            String link = links.get(i);
            bitmaps.add(downloadImage(link));
        }
        return bitmaps;
    }


    private Bitmap downloadImage(String link) {
        try {
            URL ulrn = new URL(link);
            HttpURLConnection con = (HttpURLConnection) ulrn.openConnection();
            InputStream iS = con.getInputStream();
            return BitmapFactory.decodeStream(iS);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<Bitmap> bitmaps) {
        super.onPostExecute(bitmaps);
        for (int i=0;i<bitmaps.size();i++){
            this.bitmaps.add(bitmaps.get(i));
        }
        progressDialog.dismiss();
        Fragment_Home.flag=true;
        Fragment_Home.adapterListViewHome.notifyDataSetChanged();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("Vui lòng chờ...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
}
