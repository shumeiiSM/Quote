package com.example.quote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowFav extends AppCompatActivity {

    CircleImageView ivBack;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ShowAdapter adapter;
    private ArrayList<ShowClass> show;

//    String[] allBack = new String[10];
//    String[] allQuote = new String[10];
//    String[] allAuthor = new String[10];
//    String[] allCat = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fav);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ivBack = findViewById(R.id.ivBack);
        mRecyclerView = findViewById(R.id.recyclerView);

        // Recieve data
//        Intent intentReceived = getIntent();
//        String thebackground = intentReceived.getStringExtra("background");
//        String thequote = intentReceived.getStringExtra("quote");
//        String theauthor = intentReceived.getStringExtra("author");
//        String thecatName = intentReceived.getStringExtra("catName");

        // Retrieve the saved data from the SharedPreferences object
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ShowFav.this);
        int thebackground = prefs.getInt("background", 0);
        String thequote = prefs.getString("quote", "no quote");
        String theauthor = prefs.getString("author", "no author");
        String thecatName = prefs.getString("catName", "no category");

        if (thebackground != 0 && thequote != null && theauthor != null && thecatName != null) {

            show = new ArrayList<>();

            show.add(new ShowClass(thequote, thecatName, theauthor, thebackground));

            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(ShowFav.this);

            adapter = new ShowAdapter(this, show);

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(adapter);

        } else {
            Toast.makeText(ShowFav.this, "No Favourite Quote", Toast.LENGTH_LONG).show();
        }


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
