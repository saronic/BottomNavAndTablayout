package com.android.gifts.bottomnavigation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabOneFragment extends Fragment {

    String mTitle;
    public static final String ARG_KEY = "arg key";

    public static Fragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(ARG_KEY, title);
        Fragment fragment = new TabOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitle = getArguments().getString(ARG_KEY);
    }

    public TabOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_one, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment_one_tab_layout_text_view);
        textView.setText(mTitle);
        return  view;
    }

}
