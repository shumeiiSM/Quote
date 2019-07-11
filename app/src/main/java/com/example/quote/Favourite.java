package com.example.quote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Favourite extends AppCompatActivity {

    TextView myauthor, myquote, mycat;
    Button btnFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        myauthor = findViewById(R.id.myAuthor);
        mycat = findViewById(R.id.catname);
        myquote = findViewById(R.id.quote);

        btnFav = findViewById(R.id.fav);

        // Recieve data
        Intent intent = getIntent();
        final String quote = intent.getExtras().getString("quote");
        final String author = intent.getExtras().getString("author");
        final String catName = intent.getExtras().getString("cname");

        mycat.setText(catName);
        myauthor.setText(author);
        myquote.setText(quote);

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ShowFav.class);
                intent.putExtra("qu",quote);
                intent.putExtra("au",author);
                intent.putExtra("cat",catName);
                startActivity(intent);
            }
        });


    }
}
