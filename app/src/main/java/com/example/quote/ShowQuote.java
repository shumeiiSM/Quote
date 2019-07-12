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
                finish();
//                Intent intent = new Intent(getBaseContext(), Category.class);
//                startActivity(intent);
            }
        });

        // Recieve data
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");

        myCat.setText(name);

        quotes = new ArrayList<>();

        if (name.equals("Inspirational")) {
            quotes.add(new Quote("Roosevelt" ,name, R.drawable.inspirational));
            quotes.add(new Quote("Peale" ,name,R.drawable.inspirational));
            quotes.add(new Quote("Churchill" ,name,R.drawable.inspirational));
            quotes.add(new Quote("Connelly" ,name,R.drawable.inspirational));
            quotes.add(new Quote("Roggers" ,name,R.drawable.inspirational));

        } else if (name.equals("Attitude")) {
            quotes.add(new Quote("Churchill" ,name,R.drawable.attitude));
            quotes.add(new Quote("Angelou" ,name,R.drawable.attitude));
            quotes.add(new Quote("Lombardi" ,name,R.drawable.attitude));
            quotes.add(new Quote("Winfrey" ,name,R.drawable.attitude));
            quotes.add(new Quote("West" ,name,R.drawable.attitude));

        } else if (name.equals("Courage")) {
            quotes.add(new Quote("Roosevelt" ,name,R.drawable.courage));
            quotes.add(new Quote("Einstein" ,name,R.drawable.courage));
            quotes.add(new Quote("Shakespeare" ,name,R.drawable.courage));
            quotes.add(new Quote("Kennedy" ,name,R.drawable.courage));
            quotes.add(new Quote("Emerson" ,name,R.drawable.courage));

        } else if (name.equals("Perseverance")) {
            quotes.add(new Quote("Churchill",name,R.drawable.perseverance));
            quotes.add(new Quote("Angelou",name,R.drawable.perseverance));
            quotes.add(new Quote("Nixon",name,R.drawable.perseverance));
            quotes.add(new Quote("King",name,R.drawable.perseverance));
            quotes.add(new Quote("O'Brien",name,R.drawable.perseverance));
            quotes.add(new Quote("Bradley",name,R.drawable.perseverance));

        } else if (name.equals("Enthusiasm")) {
            quotes.add(new Quote("Lombardi",name,R.drawable.enthusiasm));
            quotes.add(new Quote("Peale",name,R.drawable.enthusiasm));
            quotes.add(new Quote("Churchill",name,R.drawable.enthusiasm));
            quotes.add(new Quote("Ball",name,R.drawable.enthusiasm));
            quotes.add(new Quote("Coleridge",name,R.drawable.enthusiasm));
            quotes.add(new Quote("McFee",name,R.drawable.enthusiasm));

        } else if (name.equals("Ability")) {
            quotes.add(new Quote("Wooden",name,R.drawable.ability));
            quotes.add(new Quote("Einstein",name,R.drawable.ability));
            quotes.add(new Quote("James",name,R.drawable.ability));
            quotes.add(new Quote("Franklin",name,R.drawable.ability));
            quotes.add(new Quote("Tracy",name,R.drawable.ability));

        } else {
            quotes.add(new Quote("Russell" ,name,R.drawable.love));
            quotes.add(new Quote("Thoreau" ,name,R.drawable.love));
            quotes.add(new Quote("Shakespeare" ,name,R.drawable.love));
            quotes.add(new Quote("Lennon" ,name,R.drawable.love));
        }


        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(ShowQuote.this);

        adapter = new QuoteAdapter(this, quotes);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(adapter);


//        Intent i = new Intent(ShowQuote.this, DetailQuote.class);
//        i.putExtra("catName",name);
//        startActivity(i);

    }
}
