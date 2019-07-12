package com.example.quote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Favourite extends AppCompatActivity {

    TextView myauthor, myquote, mycat;
    Button btnFav;
    ImageView ivCatBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        myauthor = findViewById(R.id.myAuthor);
        mycat = findViewById(R.id.catname);
        myquote = findViewById(R.id.quote);
        ivCatBack = findViewById(R.id.ivCatBack);
        btnFav = findViewById(R.id.fav);

        // Recieve data
        final Intent intent = getIntent();
        final String background = String.valueOf(intent.getExtras().getInt("background"));
        final String quote = intent.getExtras().getString("quote");
        final String author = intent.getExtras().getString("author");
        final String catName = intent.getExtras().getString("cname");

        mycat.setText(catName);
        myauthor.setText(author);
        myquote.setText(quote);

        Resources res = getResources();
        int resID = res.getIdentifier(background , "drawable", getPackageName());
        ivCatBack.setImageResource(resID);

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Favourite.this);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("background", intent.getExtras().getInt("background"));
                editor.putString("quote", quote);
                editor.putString("author", author);
                editor.putString("catName", catName);
                editor.commit();

                Intent intent = new Intent(getBaseContext(), ShowFav.class);
//                intent.putExtra("background",background);
//                intent.putExtra("quote",quote);
//                intent.putExtra("author",author);
//                intent.putExtra("catName",catName);
                startActivity(intent);
            }
        });


    }
}
