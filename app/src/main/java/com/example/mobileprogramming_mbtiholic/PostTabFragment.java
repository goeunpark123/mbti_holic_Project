package com.example.mobileprogramming_mbtiholic;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostTabFragment extends Fragment {


    public PostTabFragment() {
        // Required empty public constructor
    }

    public void onClick(PostTabFragment ptf) {
        Intent intent = new Intent(ptf.getContext(), FeedActivity.class);
        startActivity(intent);
    }
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_post_tab, container, false);
        }



}

