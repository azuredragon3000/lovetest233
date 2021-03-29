package com.myapp.lovetest8121988;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Arrays;
import java.util.List;

public class MyInterstitialAd {

    private InterstitialAd interstitialAd;

    void load_ad(Activity Main){
        if (interstitialAd != null) {
            interstitialAd.show(Main);
            Log.d("cuong","onhere3");
        } else {
            // Proceed to the next level.
            //goToNextLevel();

        }
    }
    MyInterstitialAd(String device, String id_ads, Context context){
        // my device 07CC7E40850ABA2DF210A2D2564CAD76
        List<String> testDeviceIds = Arrays.asList(device);
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);

        // Create a full screen content callback.
        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
            @Override
            public void onAdDismissedFullScreenContent() {
                interstitialAd = null;
                // Proceed to the next level.
                //goToNextLevel();
            }
        };
//ca-app-pub-8404443559572571/3715462075
        InterstitialAd.load(
                context,
                id_ads,
                new AdRequest.Builder().build(),
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd ad) {
                        interstitialAd = ad;
                        interstitialAd.setFullScreenContentCallback(fullScreenContentCallback);
                        Log.d("cuong","onhere1");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        // Code to be executed when an ad request fails.
                        Log.d("cuong","onhere2");
                    }
                });
    }
}
