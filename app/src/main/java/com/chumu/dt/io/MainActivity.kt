package com.chumu.dt.io
import android.annotation.SuppressLint
import android.os.Bundle
import com.chumu.dt.v24.magicbox.base.ChuMuBaseActivity
import com.chumu.dt.v24.magicbox.swipeback.ChuMuSwipeBack

@SuppressLint("Registered")
@ChuMuSwipeBack(true)
class MainActivity : ChuMuBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}