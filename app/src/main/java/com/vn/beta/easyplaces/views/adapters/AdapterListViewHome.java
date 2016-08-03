package com.vn.beta.easyplaces.views.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vn.beta.easyplaces.R;
import com.vn.beta.easyplaces.models.Hotel;
import com.vn.beta.easyplaces.views.fragments.Fragment_Home;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by djwag on 7/27/2016.
 */
public class AdapterListViewHome extends ArrayAdapter<Hotel> {
    Context context;
    int resource;
    List<Hotel> objects;
    int widthDevice;
    /*ImageView imgImg;*/
    ArrayList<Bitmap> bitmaps=new ArrayList<>();
    public AdapterListViewHome(Context context, int resource, List<Hotel> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        widthDevice=display.getWidth();
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Hotel getItem(int position) {
        return objects.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hotel hotel= getItem(position);
        //Get the data item for this position
        ViewHolder holder = null;
        //check if an existing view is being reused, otherwise inflate the view
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(resource, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.setValue(hotel, position);
        return convertView;
    }

    private class ViewHolder{
        private TextView txtName, txtAddress, txtType, txtArea, txtPrice;
        private ImageView imgImg;

        public ViewHolder(View v){
            txtName= (TextView) v.findViewById(R.id.txtName);
            txtAddress= (TextView) v.findViewById(R.id.txtAddress);
            txtType= (TextView) v.findViewById(R.id.txtType);
            txtArea= (TextView) v.findViewById(R.id.txtArea);
            txtPrice= (TextView) v.findViewById(R.id.txtPrice);
            imgImg= (ImageView) v.findViewById(R.id.imgImage);
        }

        public void setValue(Hotel hotel, int position){
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
        }
    }
}
