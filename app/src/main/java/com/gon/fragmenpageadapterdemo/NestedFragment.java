package com.gon.fragmenpageadapterdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by G on 4/6/16.
 */
public class NestedFragment extends Fragment {

    public static NestedFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("Title", title);
        NestedFragment frag = new NestedFragment();
        frag.setArguments(args);
        return  frag;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nested, container, false);
//        ((EditText) view.findViewById(R.id.text)).setText(getArguments().getString("Title"));
        return view;
    }
}
