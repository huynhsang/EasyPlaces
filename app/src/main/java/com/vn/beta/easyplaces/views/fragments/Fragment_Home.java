package com.vn.beta.easyplaces.views.fragments;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vn.beta.easyplaces.R;
import com.vn.beta.easyplaces.models.Hotel;
import com.vn.beta.easyplaces.presenters.DownloadImage;
import com.vn.beta.easyplaces.views.adapters.AdapterListViewHome;

import java.util.ArrayList;



public class Fragment_Home extends Fragment {
    private ArrayList<Hotel> hotels;
    private ListView listView;
    public static AdapterListViewHome adapterListViewHome;
    public static ArrayList<Bitmap> bitmaps;
    public static boolean flag=false;

//    private static final String STARTING_TEXT = "BOTTOM BAR";

    public Fragment_Home() {
    }

    public static Fragment_Home newInstance() {
        Fragment_Home fragment_Home = new Fragment_Home();
        return fragment_Home;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) view.findViewById(R.id.lvHotel);
        hotels = new ArrayList<>();
        final ArrayList<String> links=new ArrayList<>();
        giaLap(links);

        adapterListViewHome = new AdapterListViewHome(
                getActivity(),
                R.layout.item_home,
                hotels);
        listView.setAdapter(adapterListViewHome);
        if (bitmaps==null){
            DownloadImage downloadImage=new DownloadImage(getContext());
            downloadImage.execute(links);
            bitmaps=downloadImage.bitmaps;
        }
        return view;
    }

    private void giaLap(ArrayList<String> links) {

        hotels.add(new Hotel("Nhà Trọ 1", "K12/34 ngô thì nhậm",
                "dãy trọ", "40-60m^2", "400-600 ngàn/tháng", "http://www.xaydungdatnguon.com/images/dichvu/1429115624_tu-van-xay-dung-nha-tro.jpg"));
        hotels.add(new Hotel("Nhà Trọ 2", "K12/34 ngô sĩ liên",
                "dãy trọ", "60-80m^2", "800-1000 ngàn/tháng", "https://fbcdn-photos-c-a.akamaihd.net/hphotos-ak-xlf1/v/t1.0-0/s403x403/8296_1555283951428831_7600305487764050737_n.jpg?oh=df95d817924aeafadbceffa367fa6913&oe=5823A4FC&__gda__=1478197573_4791449df403271acff580e5f5003745"));
        hotels.add(new Hotel("Nhà Trọ 3", "K12/34 ngô sĩ liên",
                "dãy trọ", "60-80m^2", "800-1000 ngàn/tháng", "http://www.xaydungdatnguon.com/images/dichvu/1429115624_tu-van-xay-dung-nha-tro.jpg"));
        hotels.add(new Hotel("Nhà Trọ 4", "K12/34 ngô sĩ liên",
                "dãy trọ", "60-80m^2", "800-1000 ngàn/tháng", "http://www.xaydungdatnguon.com/images/dichvu/1429115624_tu-van-xay-dung-nha-tro.jpg"));
        hotels.add(new Hotel("Nhà Trọ 5", "K12/34 ngô sĩ liên",
                "dãy trọ", "60-80m^2", "800-1000 ngàn/tháng", "http://www.xaydungdatnguon.com/images/dichvu/1429115624_tu-van-xay-dung-nha-tro.jpg"));
        hotels.add(new Hotel("Nhà Trọ 6", "K12/34 ngô sĩ liên",
                "dãy trọ", "60-80m^2", "800-1000 ngàn/tháng", "http://www.xaydungdatnguon.com/images/dichvu/1429115624_tu-van-xay-dung-nha-tro.jpg"));
        hotels.add(new Hotel("Nhà Trọ 7", "K12/34 ngô sĩ liên",
                "dãy trọ", "60-80m^2", "800-1000 ngàn/tháng", "https://scontent-hkg3-1.xx.fbcdn.net/v/t1.0-9/13614961_1187910394586621_7843891021441422156_n.jpg?oh=4e2115b6a48aa33b557dd396982835ca&oe=58134AE6"));
        links.add(hotels.get(0).getLink());
        links.add(hotels.get(1).getLink());
        links.add(hotels.get(2).getLink());
        links.add(hotels.get(3).getLink());
        links.add(hotels.get(4).getLink());
        links.add(hotels.get(5).getLink());
        links.add(hotels.get(6).getLink());
    }


}
