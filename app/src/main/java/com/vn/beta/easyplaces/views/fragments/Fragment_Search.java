package com.vn.beta.easyplaces.views.fragments;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vn.beta.easyplaces.R;


/**
 * Created by djwag on 7/27/2016.
 */
public class Fragment_Search extends Fragment {

    public Fragment_Search() {

    }

    public static Fragment_Search newInstance() {
        Fragment_Search fragment_search = new Fragment_Search();
        return fragment_search;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        return view;
    }
}
