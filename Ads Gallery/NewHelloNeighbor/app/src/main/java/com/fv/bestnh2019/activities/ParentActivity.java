package com.fv.bestnh2019.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.fv.bestnh2019.R;
import com.fv.bestnh2019.adapters.ItemAdapter;
import com.fv.bestnh2019.models.Item;
import com.fv.bestnh2019.repositories.ElementRepository;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class ParentActivity extends AppCompatActivity {

    private ElementRepository mElementRepository = new ElementRepository();
    private ItemAdapter mItemAdapter;
    private RecyclerView mRecyclerView;
    private TextView mTvName;
    private NestedScrollView mScrollView;
    private ImageView mImgBackground;
    private AdView mAdView;
    private InterstitialAd mFacebookInterstitialAd;
    private LinearLayout mLinearFacebookBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpFacebookAds();
        setUpGoogleAds();
        initViews();
        handleEvents();
    }

    private void setUpFacebookAds() {
        mFacebookInterstitialAd = new InterstitialAd(this, getString(R.string.ad_facebook_app_interstitial));
        AdSettings.addTestDevice("d661fd6a-06e6-41a9-8c10-9e33efeb53a8");
        mFacebookInterstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("tag1", adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                mFacebookInterstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        });
        mFacebookInterstitialAd.loadAd();

        mLinearFacebookBanner = findViewById(R.id.llFacebookBanner);
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getString(R.string.ad_facebook_app_banner), AdSize.BANNER_HEIGHT_50);
        mLinearFacebookBanner.addView(adView);
        adView.loadAd();
    }

    private void setUpGoogleAds() {
        MobileAds.initialize(this, getString(R.string.admob_appid));
        new AdRequest.Builder().addTestDevice("2612B9122790D85B0D6D5C7A51AF90EE");
        //adview
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void handleEvents() {
        mItemAdapter.setElementListener(new ItemAdapter.ElementListener() {
            @Override
            public void onItemClick(Item item) {
                Intent intent = new Intent(ParentActivity.this, ChildActivity.class);
                intent.putExtra("detailResourceId", item.getDetailResourceId());
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mTvName = findViewById(R.id.tvName);
        mScrollView = findViewById(R.id.scrollView);
        mImgBackground = findViewById(R.id.imgBackground);

        Picasso.get().load(R.drawable.cover_image).into(mImgBackground);
        mTvName.setText(getString(R.string.home_name));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setNestedScrollingEnabled(false);
        mItemAdapter = new ItemAdapter(mElementRepository.getListGames());
        mRecyclerView.setAdapter(mItemAdapter);
        mScrollView.post(new Runnable() {
            @Override
            public void run() {
                if (mScrollView != null) {
                    mScrollView.scrollTo(0, 0);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
