package com.ellekay.lucie.fashionhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity {

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
}