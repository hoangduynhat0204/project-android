package com.fv.bestnh2019.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.fv.bestnh2019.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;


public class ChildActivity extends AppCompatActivity {
    private int detailId = R.drawable.img_guide;
    private ImageView mImgDetail;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private boolean isAdRead;
    private ImageView mImgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        setUpAds();
        initViews();
        hanldeEvents();
        fetchData();
    }

    private void hanldeEvents() {
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setUpAds() {
        MobileAds.initialize(this, getString(R.string.admob_appid));
        new  AdRequest.Builder().addTestDevice("2612B9122790D85B0D6D5C7A51AF90EE");
        //adview
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //fullscreen gg ads
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                //load fullscreen ads
                if (!isAdRead) {
                    mInterstitialAd.show();
                    isAdRead = true;
                }
            }
        });
    }

    private void fetchData() {
        if (getIntent() != null) {
            detailId = getIntent().getIntExtra("detailResourceId", R.drawable.img_guide);
        }
        Picasso.get().load(detailId).into(mImgDetail);
    }

    private void initViews() {
        mImgDetail = findViewById(R.id.imgDetail);
        mImgBack = findViewById(R.id.ivBack);
    }

}
