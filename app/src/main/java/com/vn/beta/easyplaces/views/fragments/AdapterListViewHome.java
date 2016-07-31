package com.vn.beta.easyplaces.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vn.beta.easyplaces.R;
import com.vn.beta.easyplaces.views.models.Hotel;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by djwag on 7/27/2016.
 */
public class AdapterListViewHome extends ArrayAdapter<Hotel> {
     Context context;
    int resource;
    List objects;
    int widthDevice;
    ImageView imgImg;
    ArrayList<Bitmap> bitmaps=new ArrayList<>();
    public AdapterListViewHome(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        widthDevice=display.getWidth();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=((Activity)getContext()).getLayoutInflater().inflate(R.layout.item_home,null);
        Hotel hotel= (Hotel) objects.get(position);
        TextView txtName= (TextView) v.findViewById(R.id.txtName);
        TextView txtAddress= (TextView) v.findViewById(R.id.txtAddress);
        TextView txtType= (TextView) v.findViewById(R.id.txtType);
        TextView txtArea= (TextView) v.findViewById(R.id.txtArea);
        TextView txtPrice= (TextView) v.findViewById(R.id.txtPrice);
        imgImg= (ImageView) v.findViewById(R.id.imgImage);
        txtName.setText(
                hotel.getName());
        txtName.setMaxWidth((int)widthDevice*50/100);
        txtAddress.setText(hotel.getAddress());
        txtAddress.setMaxWidth((int)widthDevice*50/100);
        txtType.setText(hotel.getType());
        txtType.setMaxWidth((int)widthDevice*50/100);
        txtArea.setText(hotel.getArea());
        txtArea.setMaxWidth((int)widthDevice*50/100);
        txtPrice.setText(hotel.getPrice());
        txtPrice.setMaxWidth((int)widthDevice*50/100);
        if (Fragment_Home.flag==true){
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Bitmap bm=Fragment_Home.bitmaps.get(position);
            imgImg.setImageBitmap(Bitmap.createScaledBitmap(bm,
                    display.getWidth()/2,
                    display.getHeight()/5,
                    false));
        }

        return v;
    }
}
