package com.chumu.dt.io;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.chumu.dt.v24.magicbox.swipeback.ChuMuSwipeBack;

@Deprecated
@ChuMuSwipeBack(true)
public  class ChuMuMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
