package com.example.mobileprogramming_mbtiholic;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class FeedActivity extends AppCompatActivity {

    FeedAdapter feedAdapter;
    ArrayList<Post> postingList= new ArrayList<>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        long now = System.currentTimeMillis();




     postingList.add(new Post("박설", "20181025" ,"오늘은 회의가 두개다"));
     postingList.add(new Post("박설","20181025","오늘은 회의가 세개다"));
     postingList.add(new Post("박설","20181025","오늘은 회의가 네개다"));
     postingList.add(new Post("박설","20181025","오늘은 회의가 다섯개다"));
     feedAdapter=new FeedAdapter(this, postingList, R.layout.fragment_post_tab);
     listView= findViewById(R.id.postingList);
     listView.setAdapter(feedAdapter);






    }


}
