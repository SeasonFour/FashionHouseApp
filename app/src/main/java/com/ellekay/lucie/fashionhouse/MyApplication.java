package com.ellekay.lucie.fashionhouse;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by lucie on 11/4/15.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {

        super.onCreate();
      /*  ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        ImageLoader.getInstance().init(config);
        MyApplication.imageLoader.init(ImageLoaderConfiguration.createDefault(getBaseContext()));*/

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(MyApplication.this));
    }
}
