package com.example.quote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Category extends AppCompatActivity {

    CircleImageView ivBack;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private CatAdapter adapter;
    private ArrayList<Cat> cats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        cats = new ArrayList<>();
        cats.add(new Cat(R.drawable.inspirational, "Inspirational"));
        cats.add(new Cat(R.drawable.attitude, "Attitude"));
        cats.add(new Cat(R.drawable.courage, "Courage"));
        cats.add(new Cat(R.drawable.perseverance, "Perseverance"));
        cats.add(new Cat(R.drawable.enthusiasm, "Enthusiasm"));
        cats.add(new Cat(R.drawable.ability, "Ability"));
        cats.add(new Cat(R.drawable.love, "Love"));

        ivBack = findViewById(R.id.ivBack);
        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(Category.this);

        adapter = new CatAdapter(this, cats);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
