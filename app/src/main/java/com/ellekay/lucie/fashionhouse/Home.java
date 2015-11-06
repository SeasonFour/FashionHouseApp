package com.ellekay.lucie.fashionhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;


public class Home extends AppCompatActivity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {

    private static final String TAG = "STAGGERED GRID";
    public static final String SAVED_DATA_KEY = "SAVED_DATA_KEY";

    private StaggeredGridView myGridView;
    private boolean mHasRequestedMore;
    private HomeAdapter homeAdapter;

    private ArrayList<String> myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));


        setTitle("Fashion House b-Home");
        myGridView = (StaggeredGridView) findViewById(R.id.grid_view);
        homeAdapter = new HomeAdapter(this, android.R.layout.simple_list_item_1, generateData());

        if (savedInstanceState != null){
            myData = savedInstanceState.getStringArrayList(SAVED_DATA_KEY);
        }

        if (myData == null){
            myData = generateData();
        }

        for (String data : myData){
            homeAdapter.add(data);
        }

        myGridView.setAdapter(homeAdapter);
        myGridView.setOnScrollListener(this);
        myGridView.setOnItemClickListener(this);


        //creating the circular button
        final com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton mymenu =
                new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.Builder(this)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(this);
        //Setting icons to the buttons
        ImageView rlIcon1 = new ImageView(this);
        ImageView rlIcon2 = new ImageView(this);
        ImageView rlIcon3 = new ImageView(this);
        ImageView rlIcon4 = new ImageView(this);
        ImageView rlIcon5 = new ImageView(this);
        //setting icons for the buttons
        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.help));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.business));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.cartfull));
        rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.car));
        rlIcon5.setImageDrawable(getResources().getDrawable(R.drawable.car));

        //creating the floating action menu subButtos being created dynamically
        final FloatingActionMenu myFloatingMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(rLSubBuilder.setContentView(rlIcon1).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon2).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon3).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon4).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon5).build())
                .attachTo(mymenu)
                .build();

        rlIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, help.class);
                startActivity(i);
            }
        });
        rlIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Home.this, Contact.class);
                startActivity(i2);
            }
        });
        rlIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Home.this, Checkout.class);
                startActivity(i3);
            }
        });
        rlIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Home.this, MakeUp.class);
                startActivity(i4);
            }
        });

        rlIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Home.this, Category.class);
                startActivity(i5);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(SAVED_DATA_KEY, myData);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item clicked: " +position, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        Log.d(TAG, "onscrollstatechanged" + scrollState);

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        Log.d(TAG, "onScrollFirstItem:" +firstVisibleItem + "visibleCount:" +visibleItemCount + "totalcount:" +totalItemCount);
        if (mHasRequestedMore){
            int lastInSreen = firstVisibleItem + visibleItemCount;
            if (lastInSreen >= totalItemCount){
                Log.d(TAG, "onscroll last in screeen -so load more");
                mHasRequestedMore = true;
                onLoadMore();

            }
        }
    }

    private void onLoadMore(){
        final ArrayList<String> sampleData = generateData();
        for (String data : sampleData){
            homeAdapter.add(data);
        }
        myData.addAll(sampleData);
        homeAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }

    private ArrayList<String> generateData(){
        ArrayList<String> listData = new ArrayList<String>();
        listData.add("http://gloimg.sammydress.com/S/2015/201509/source-img/1442525830059-P-3136085.jpeg");//dress
        listData.add("http://www.wholesale7.net/images/201204/goods_img/28941_P_1335321411963.jpg"); //shoes
        listData.add("https://s-media-cache-ak0.pinimg.com/736x/5e/19/1c/5e191cdc55ed358a4c8b44f862efcc68.jpg"); //bag
        listData.add("http://s7ondemand4.scene7.com/is/image/Signet/9649018?$detail745$"); //jewellery
        listData.add("http://www.womentip.com/wp-content/uploads/2014/12/Makeup-Kits.jpeg");//makeup
        listData.add("http://d236bkdxj385sg.cloudfront.net/wp-content/uploads/2011/03/afroheadband.jpg");//hair
        Log.d(TAG,"SIZE"+listData.size());
        return listData;
    }

}
