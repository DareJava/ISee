package com.iseeapp.isee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.iseeapp.isee.adapters.DividerItemDecoration;
import com.iseeapp.isee.adapters.UploadedResourceAdapter;
import com.iseeapp.isee.listeners.RecyclerTouchListener;
import com.iseeapp.isee.utilities.IseeUtility;

public class FilteredListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UploadedResourceAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtered_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_result);



        mAdapter = new UploadedResourceAdapter(IseeUtility.prepareUploadedTestData());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        addTouchListenerToTrendingList(recyclerView);

    }


    private void addTouchListenerToTrendingList(RecyclerView mRecyclerView) {
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new RecyclerTouchListener
                .OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //handle click events here`
                launchActivity(BreakdownActivity.class);
                //Toast.makeText(getApplicationContext(),position + " is selected!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(View view, int position) {
                //handle longClick if any
            }
        }));
    }

    private void launchActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


}
