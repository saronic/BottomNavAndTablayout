package com.android.gifts.bottomnavigation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mTabLayout = (TabLayout) view.findViewById(R.id.fragment_one_tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.fragment_one_view_pager);
        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getChildFragmentManager());
        fragmentAdapter.addFragment(TabOneFragment.newInstance("one"), "one");
        fragmentAdapter.addFragment(TabOneFragment.newInstance("two"), "two");
        fragmentAdapter.addFragment(TabOneFragment.newInstance("Three"), "Three");
        fragmentAdapter.addFragment(TabOneFragment.newInstance("Four"), "Four");
        mViewPager.setAdapter(fragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }


    class TabFragmentAdapter extends FragmentPagerAdapter {
        List<Fragment> mFragmentList = new ArrayList<>();
        List<String> mFragmentTitleList = new ArrayList<>();
        public TabFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
