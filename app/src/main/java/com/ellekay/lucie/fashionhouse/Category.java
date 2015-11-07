package com.ellekay.lucie.fashionhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private StaggeredGridLayoutManager glmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.home_recycler);
        recyclerView.setHasFixedSize(true);

        glmanager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(glmanager);

        List<CategoryClass> gList = getDataItem();

        CategoryAdapter cAdapter = new CategoryAdapter(this,gList);
        recyclerView.setAdapter(cAdapter);

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
                Intent i = new Intent(Category.this, help.class);
                startActivity(i);
            }
        });
        rlIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Category.this, Contact.class);
                startActivity(i2);
            }
        });
        rlIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Category.this, Checkout.class);
                startActivity(i3);
            }
        });
        rlIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Category.this, Gotocart.class);
                startActivity(i4);
            }
        });

        rlIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Category.this, Category.class);
                startActivity(i5);
            }
        });

    }

    private List<CategoryClass> getDataItem(){
        List<CategoryClass> categoryItem = new ArrayList<CategoryClass>();
        categoryItem.add(new CategoryClass("Dresses", R.drawable.dressess));
        categoryItem.add(new CategoryClass("Jewellery", R.drawable.goldd));
        categoryItem.add(new CategoryClass("Bags", R.drawable.bagg));
        categoryItem.add(new CategoryClass("Make up", R.drawable.makeupp));
        categoryItem.add(new CategoryClass("Shoes", R.drawable.shoess));
        return categoryItem;

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("msg", ""+position);

    }
}