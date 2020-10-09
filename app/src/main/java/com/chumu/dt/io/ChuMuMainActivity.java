package com.chumu.dt.io;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.Observer;

import com.chumu.dt.v24.magicbox.base.ChuMuBaseActivity;
import com.chumu.dt.v24.magicbox.livedatabus.ChuMuLiveDataBus;
import com.chumu.dt.v24.magicbox.livedatabus.event.ChuMuEvent;
import com.chumu.dt.v24.magicbox.swipeback.ChuMuSwipeBack;

import java.util.ArrayList;

@Deprecated
@ChuMuSwipeBack(true)
public class ChuMuMainActivity extends ChuMuBaseActivity {

    private IMyAidlInterface mIMyAidlInterface;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                list.add("1");
                list.add("2");
                list.add("3");
                list.add("4");
                ChuMuLiveDataBus.INSTANCE.send("2",list);

            }
        });
        btn.getParent().requestDisallowInterceptTouchEvent(true);
        ChuMuLiveDataBus.INSTANCE.with("2").observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object o) {
                ArrayList<String> list= (ArrayList<String>) o;
                Toast.makeText(ChuMuMainActivity.this,list.size()+"", Toast.LENGTH_SHORT).show();
            }
        });
//        ServiceConnection conn = new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//                mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
//            }
//
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//
//            }
//        };
//        bindService(new Intent(),conn, Context.BIND_AUTO_CREATE);
//        try {
//            mIMyAidlInterface.getWorkInfo();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }
}
