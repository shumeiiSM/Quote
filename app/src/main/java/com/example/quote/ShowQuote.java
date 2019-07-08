package com.example.quote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowQuote extends AppCompatActivity {

    CircleImageView ivBack;
    TextView myCat;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private QuoteAdapter adapter;
    private ArrayList<Quote> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showquote);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ivBack = findViewById(R.id.ivBack);
        myCat = findViewById(R.id.myCategory);
        mRecyclerView = findViewById(R.id.recyclerView);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Category.class);
                startActivity(intent);
            }
        });

        // Recieve data
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");

        myCat.setText(name);

        quotes = new ArrayList<>();

        if (name.equals("Inspirational")) {
            quotes.add(new Quote("Roosevelt" ,R.drawable.inspirational));
            quotes.add(new Quote("Peale" ,R.drawable.inspirational));
            quotes.add(new Quote("Churchill" ,R.drawable.inspirational));
            quotes.add(new Quote("Connelly" ,R.drawable.inspirational));
            quotes.add(new Quote("Roggers" ,R.drawable.inspirational));

        } else if (name.equals("Attitude")) {
            quotes.add(new Quote("Churchill" ,R.drawable.attitude));
            quotes.add(new Quote("Angelou" ,R.drawable.attitude));
            quotes.add(new Quote("Lombardi" ,R.drawable.attitude));
            quotes.add(new Quote("Angelou" ,R.drawable.attitude));
            quotes.add(new Quote("Winfrey" ,R.drawable.attitude));
            quotes.add(new Quote("West" ,R.drawable.attitude));

        } else if (name.equals("Courage")) {
            quotes.add(new Quote("Roosevelt" ,R.drawable.courage));
            quotes.add(new Quote("Einstein" ,R.drawable.courage));
            quotes.add(new Quote("Shakespeare" ,R.drawable.courage));
            quotes.add(new Quote("Kennedy" ,R.drawable.courage));
            quotes.add(new Quote("Emerson" ,R.drawable.courage));

        } else if (name.equals("Perseverance")) {
            quotes.add(new Quote("Churchill",R.drawable.perseverance));
            quotes.add(new Quote("Angelou",R.drawable.perseverance));
            quotes.add(new Quote("Nixon",R.drawable.perseverance));
            quotes.add(new Quote("King",R.drawable.perseverance));
            quotes.add(new Quote("O'Brien",R.drawable.perseverance));
            quotes.add(new Quote("Bradley",R.drawable.perseverance));

        } else if (name.equals("Enthusiasm")) {
            quotes.add(new Quote("Lombardi",R.drawable.enthusiasm));
            quotes.add(new Quote("Peale",R.drawable.enthusiasm));
            quotes.add(new Quote("Churchill",R.drawable.enthusiasm));
            quotes.add(new Quote("Ball",R.drawable.enthusiasm));
            quotes.add(new Quote("Coleridge",R.drawable.enthusiasm));
            quotes.add(new Quote("McFee",R.drawable.enthusiasm));

        } else if (name.equals("Ability")) {
            quotes.add(new Quote("Wooden",R.drawable.ability));
            quotes.add(new Quote("Einstein",R.drawable.ability));
            quotes.add(new Quote("James",R.drawable.ability));
            quotes.add(new Quote("Franklin",R.drawable.ability));
            quotes.add(new Quote("Tracy",R.drawable.ability));

        } else {
            quotes.add(new Quote("Russell" ,R.drawable.love));
            quotes.add(new Quote("Thoreau" ,R.drawable.love));
            quotes.add(new Quote("Shakespeare" ,R.drawable.love));
            quotes.add(new Quote("Lennon" ,R.drawable.love));
        }


        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(ShowQuote.this);

        adapter = new QuoteAdapter(this, quotes);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(adapter);


        Intent i = new Intent(ShowQuote.this, DetailQuote.class);
        i.putExtra("catName",name);
        startActivity(i);

    }
}
