package com.vn.beta.easyplaces.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarBadge;
import com.roughike.bottombar.BottomBarFragment;
import com.roughike.bottombar.OnTabSelectedListener;
import com.vn.beta.easyplaces.R;
import com.vn.beta.easyplaces.views.fragments.Fragment_Home;
import com.vn.beta.easyplaces.views.fragments.Fragment_Search;
import com.vn.beta.easyplaces.views.fragments.SampleFragment;


public class MainActivity extends AppCompatActivity {
    BottomBar bottomBar;
    ActionBar actionBar;
    TextView txtTitle;
    Button btnToMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls(savedInstanceState);
        addEvents();

    }

    private void addEvents() {
        btnToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        bottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onItemSelected(int position) {
                switch (position){
                    case 0:
                        txtTitle.setText("Trang Chủ");
                        btnToMap.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        txtTitle.setText("Tìm Kiếm");
                        btnToMap.setVisibility(View.GONE);
                        break;
                    case 2:
                        txtTitle.setText("Đã Lưu");
                        btnToMap.setVisibility(View.GONE);
                        break;
                    case 3:
                        txtTitle.setText("Thông Báo");
                        btnToMap.setVisibility(View.GONE);
                        break;
                    case 4:
                        txtTitle.setText("Menu");
                        btnToMap.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }

    private void addControls(Bundle savedInstanceState) {
        bottomBar=BottomBar.attach(this,savedInstanceState);
        Fragment_Home fragment_home=Fragment_Home.newInstance();
        Fragment_Search fragment_search= Fragment_Search.newInstance();

        bottomBar.setFragmentItems(getSupportFragmentManager(),R.id.container,
                new BottomBarFragment(fragment_home,R.drawable.ic_home_black_24dp,"Home"),
                new BottomBarFragment(fragment_search,R.drawable.ic_search_black_24dp,"Search"),
                new BottomBarFragment(SampleFragment.newInstance("save"),R.drawable.ic_bookmark_border_black_24dp,"Save"),
                new BottomBarFragment(SampleFragment.newInstance("notification"),R.drawable.ic_notifications_none_black_24dp,"Noti.."),
                new BottomBarFragment(SampleFragment.newInstance("setting"),R.drawable.ic_menu_black_24dp,"Menu")
        );
        bottomBar.mapColorForTab(0, "#D32F2F");
        bottomBar.mapColorForTab(1, "#00796B");
        bottomBar.mapColorForTab(2, "#7B1FA2");
        bottomBar.mapColorForTab(3, "#3B494C");
        bottomBar.mapColorForTab(4, "#FFF9B70E");


        BottomBarBadge bottomBarBadge=bottomBar.makeBadgeForTabAt(3,"#1A237E",4);
        bottomBarBadge.show();
        bottomBarBadge.setAnimationDuration(200);
        actionBar=getSupportActionBar();
        actionBar.setTitle("Trang Chủ");
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.layout_toolbar);
        txtTitle = (TextView) findViewById(R.id.myToolbarTitle);
        btnToMap= (Button) findViewById(R.id.btnToMap);


    }
}

