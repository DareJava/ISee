package com.iseeapp.isee;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.iseeapp.isee.adapters.DividerItemDecoration;
import com.iseeapp.isee.adapters.UploadedResourceAdapter;
import com.iseeapp.isee.listeners.RecyclerTouchListener;
import com.iseeapp.isee.pojo.UploadedResource;
import com.iseeapp.isee.utilities.IseeUtility;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {
    Context context;
    ListView trendinglist;
    private List<UploadedResource> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UploadedResourceAdapter mAdapter;
    private Button loginButton;
    private Button capturButton;
    private Button categoriesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        context=this;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        loginButton = (Button) findViewById(R.id.login);
        capturButton = (Button) findViewById(R.id.capture);
        categoriesButton = (Button) findViewById(R.id.categories);


        mAdapter = new UploadedResourceAdapter(IseeUtility.prepareUploadedTestData());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        hideButtonBasedOnSharedPref();
        registerButtonListeners(loginButton, LoginActivity.class);
        registerButtonListeners(categoriesButton, CategoryActivity.class);
        registerButtonListeners(capturButton, CaptureActivity.class);
        addTouchListenerToTrendingList(recyclerView);
    }




    private void hideButtonBasedOnSharedPref() {
       boolean isLoggedIn =  IseeUtility.isUserAlreadyLoggedIn(this);
//        if (isLoggedIn) {
//            loginButton.setVisibility(View.GONE);
//            capturButton.setVisibility(View.VISIBLE);
//        } else {
//            loginButton.setVisibility(View.VISIBLE);
//            capturButton.setVisibility(View.GONE);
//        }
    }

    private void registerButtonListeners(Button button, final Class clazz) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(clazz);
            }
        });
    }

    private void launchActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
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
}
