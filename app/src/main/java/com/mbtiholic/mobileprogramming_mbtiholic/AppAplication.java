package com.mbtiholic.mobileprogramming_mbtiholic;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;

public class AppAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Glide.get(this).setMemoryCategory(MemoryCategory.HIGH);
    }
}
