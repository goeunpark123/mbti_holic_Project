package com.example.mobileprogramming_mbtiholic.TestPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mobileprogramming_mbtiholic.R;

public class TestTabFragment extends Fragment {

    private WebView web;
    public TestTabFragment() {

    }
    public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_test, container, false); // 전체 뷰를 가져옴

        web = (WebView)view.findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);

        web.loadUrl("https://www.16personalities.com/ko");
        web.setWebViewClient(new WebViewClient());
        return view;
    }

}






