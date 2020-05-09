package com.example.mobileprogramming_mbtiholic;


import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Date;

public class FeedAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Post> arrayList;
    int layout;

    public FeedAdapter(Activity context, ArrayList<Post> arrayList, int layout) {
        this.context = context;
        this.arrayList = arrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null)
            view=View.inflate(context,layout, null);
        TextView writer = view.findViewById(R.id.writer);
        TextView content = view.findViewById(R.id.content);

        writer.setText(arrayList.get(position).writer);
        content.setText(arrayList.get(position).content);

        return view;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
