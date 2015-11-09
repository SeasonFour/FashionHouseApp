package com.ellekay.lucie.fashionhouse;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.security.MessageDigest.getInstance;

/**
 * Created by lucie on 11/4/15.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {

        super.onCreate();
        printHashKey();
      /*  ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        ImageLoader.getInstance().init(config);
        MyApplication.imageLoader.init(ImageLoaderConfiguration.createDefault(getBaseContext()));*/

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(MyApplication.this));
    }
    public void printHashKey(){
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.ellekay.lucie.fashionhouse",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
    }

