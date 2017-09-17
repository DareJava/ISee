package com.iseeapp.isee;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.iseeapp.isee.adapters.CategoryAdapter;
import com.iseeapp.isee.adapters.CommentsAdapter;
import com.iseeapp.isee.utilities.IseeUtility;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView = (ListView) findViewById(R.id.listViewCategory);

        CategoryAdapter cAdapter = new CategoryAdapter(this, IseeUtility.prepareCategoryTestData());
        listView.setAdapter(cAdapter);

        addListViewClickListener(listView);
    }

    private void addListViewClickListener(ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                launchActivity(FilteredListActivity.class);
            }
        });

    }

    private void launchActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
