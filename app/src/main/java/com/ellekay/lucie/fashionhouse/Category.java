package com.ellekay.lucie.fashionhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity {

    private StaggeredGridLayoutManager glmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.home_recycler);
        recycler.setHasFixedSize(true);

        glmanager = new StaggeredGridLayoutManager(3, 1);
        recycler.setLayoutManager(glmanager);

        List<CategoryClass> gList = getData();
        CategoryAdapter cAdapter = new CategoryAdapter(Category.this,gList);
        recycler.setAdapter(cAdapter);
    }

    private List<CategoryClass> getData(){
        List<CategoryClass> categoryItem = new ArrayList<CategoryClass>();
        categoryItem.add(new CategoryClass("Dresses", R.drawable.dresses));
        categoryItem.add(new CategoryClass("Dresses", R.drawable.dresses));
        categoryItem.add(new CategoryClass("Dresses", R.drawable.dresses));
        categoryItem.add(new CategoryClass("Dresses", R.drawable.dresses));
        categoryItem.add(new CategoryClass("Dresses", R.drawable.dresses));
        return categoryItem;

    }
}
