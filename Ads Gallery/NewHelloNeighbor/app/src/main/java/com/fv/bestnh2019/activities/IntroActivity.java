package com.fv.bestnh2019.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.fv.bestnh2019.R;

public class IntroActivity extends AppCompatActivity {

    private static final int TIME_DELAYED = 1000;
    private Handler mHandler;
    private Runnable mActivityStarter = new Runnable() {
        @Override
        public void run() {
            IntroActivity.this.startActivity(new Intent(IntroActivity.this, ParentActivity.class));
            ActivityCompat.finishAffinity(IntroActivity.this);
            IntroActivity.this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mHandler = new Handler();
        mHandler.postDelayed(mActivityStarter, TIME_DELAYED);
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacks(mActivityStarter);
        mHandler = null;
        super.onDestroy();
    }
}
