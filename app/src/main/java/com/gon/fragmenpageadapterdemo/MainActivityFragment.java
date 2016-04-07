package com.gon.fragmenpageadapterdemo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private List<NestedFragment> mFragList;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            NestedFragment frag = NestedFragment.newInstance(String.valueOf(i));
            mFragList.add(frag);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ViewPager pager = (ViewPager) view.findViewById(R.id.viewpager);
        SampleFragmentPagerAdapter adapter = new SampleFragmentPagerAdapter(getChildFragmentManager());
        adapter.setFrags(mFragList);
        pager.setAdapter(adapter);
        return view;
    }



    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

        public SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setFrags(List<NestedFragment> fragList) {
            mFragList = fragList;
        }

        @Override
        public int getCount() {
            return mFragList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return mFragList.get(position).getArguments().getString("Title");
        }
    }
}
