package com.example.quote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailQuote extends AppCompatActivity {

    CircleImageView ivBack;
    TextView myAut;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private DetailAdapter adapter;
    private ArrayList<Detail> details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quote);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ivBack = findViewById(R.id.ivBack);
        myAut = findViewById(R.id.myAuthor);
        mRecyclerView = findViewById(R.id.recyclerView);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ShowQuote.class);
                startActivity(intent);
            }
        });

        // Recieve data
        Intent intent = getIntent();
        String author = intent.getExtras().getString("author");

        myAut.setText(author);

        String catName = intent.getStringExtra("catName");
//
//        details = new ArrayList<>();
//
//        if (catName.equals("Inspirational")) {
//            if (author.equalsIgnoreCase("Roosevelt")) {
//                details.add(new Detail("Believe you can and you're halfway there.", R.drawable.inspirational));
//                details.add(new Detail("With self-discipline most anything is possible.", R.drawable.inspirational));
//            } else if (author.equalsIgnoreCase("Peale")) {
//                details.add(new Detail("Change your thoughts and you change your world.", R.drawable.inspirational));
//            } else if (author.equalsIgnoreCase("Churchill")) {
//                details.add(new Detail("Success is never final. Failure is never fatal. It is courage that counts.", R.drawable.inspirational));
//            } else if (author.equalsIgnoreCase("Connelly")) {
//                details.add(new Detail("If you're young you are lucky. If you're are old you are even luckier!", R.drawable.inspirational));
//            } else if (author.equalsIgnoreCase("Roggers")) {
//                details.add(new Detail("If you find yourself in a hole, the first thing to do is stop digging.", R.drawable.inspirational));
//            }
//
//        } else if (catName.equals("Attitude")) {
//            if (author.equalsIgnoreCase("Churchill")) {
//                details.add(new Detail("Attitude is a little thing that makes a big difference.", R.drawable.attitude));
//            } else if (author.equalsIgnoreCase("Angelou")) {
//                details.add(new Detail("We may encounter many defeats but we must not be defeated.", R.drawable.attitude));
//            } else if (author.equalsIgnoreCase("Lombardi")) {
//                details.add(new Detail("Winning isn't everything, but the will to win is everything.", R.drawable.attitude));
//            } else if (author.equalsIgnoreCase("Winfrey")) {
//                details.add(new Detail("I'm black, I don't feel burdened by it and I don't think it's a huge responsibility. It's part of who I am. It does not define me.", R.drawable.attitude));
//            } else if (author.equalsIgnoreCase("West")) {
//                details.add(new Detail("Those who are easily shocked should be shocked more often.", R.drawable.attitude));
//            }
//
//        } else if (catName.equals("Courage")) {
//            if (author.equalsIgnoreCase("Roosevelt")) {
//                details.add(new Detail("Courtesy is as much a mark of a gentleman as courage.", R.drawable.courage));
//            } else if (author.equalsIgnoreCase("Einstein")) {
//                details.add(new Detail("Learn from yesterday, live for today, hope for tomorrow. The important thing is not to stop questioning.", R.drawable.courage));
//            } else if (author.equalsIgnoreCase("Shakespeare")) {
//                details.add(new Detail("Who could refrain that had a heart to love and in that heart courage to make love known?.", R.drawable.courage));
//            } else if (author.equalsIgnoreCase("Kennedy")) {
//                details.add(new Detail("Efforts and courage are not enough without purpose and direction.", R.drawable.courage));
//            } else if (author.equalsIgnoreCase("Emerson")) {
//                details.add(new Detail("Half a man's wisdom goes with his courage.", R.drawable.courage));
//            } else if (author.equalsIgnoreCase("Williams")) {
//                details.add(new Detail("The road of life twists and turns and no two directions are ever the same. Yet our lessons come from the journey, not the destination.", R.drawable.courage));
//            }
//
//        } else if (catName.equals("Perseverance")) {
//            if (author.equalsIgnoreCase("Churchill")) {
//                details.add(new Detail("Never, never, never, never give up.", R.drawable.perseverance));
//            } else if (author.equalsIgnoreCase("Angelou")) {
//                details.add(new Detail("All great achievements require time.", R.drawable.perseverance));
//            } else if (author.equalsIgnoreCase("Nixon")) {
//                details.add(new Detail("A man is not finished when he's defeated; he's finished when he quits.", R.drawable.perseverance));
//            } else if (author.equalsIgnoreCase("King")) {
//                details.add(new Detail("Champions keep playing until they get it right.", R.drawable.perseverance));
//            } else if (author.equalsIgnoreCase("O'Brien")) {
//                details.add(new Detail("The only way to overcome is to hang in.", R.drawable.perseverance));
//            } else if (author.equalsIgnoreCase("Bradley")) {
//                details.add(new Detail("Never give up. Keep your thoughts and your mind always on the goal.", R.drawable.perseverance));
//            }
//
//        } else if (catName.equals("Enthusiasm")) {
//            if (author.equalsIgnoreCase("Lombardi")) {
//                details.add(new Detail("If you are not fired with enthusiasm, you will be fired with enthusiasm.", R.drawable.enthusiasm));
//            } else if (author.equalsIgnoreCase("Peale")) {
//                details.add(new Detail("If you have zest and enthusiasm you attract zest and enthusiasm. Life does give back in kind.", R.drawable.enthusiasm));
//            } else if (author.equalsIgnoreCase("Churchill")) {
//                details.add(new Detail("Success is bounding from failure to failure with no loss of enthusiasm.", R.drawable.enthusiasm));
//            } else if (author.equalsIgnoreCase("Ball")) {
//                details.add(new Detail("Knowledge is power, but enthusiasm pulls the switch.", R.drawable.enthusiasm));
//            } else if (author.equalsIgnoreCase("Coleridge")) {
//                details.add(new Detail("Nothing is so contagious as enthusiasm.", R.drawable.enthusiasm));
//            } else if (author.equalsIgnoreCase("McFee")) {
//                details.add(new Detail("The world belongs to the enthusiast who keeps cool.", R.drawable.enthusiasm));
//            }
//
//        } else if (catName.equals("Ability")) {
//            if (author.equalsIgnoreCase("Wooden")) {
//                details.add(new Detail("Ability may get you to the top, but it takes character to keep you there.", R.drawable.ability));
//            } else if (author.equalsIgnoreCase("Einstein")) {
//                details.add(new Detail("The value of a man should be seen in what he gives and not in what he is able to receive.", R.drawable.ability));
//            } else if (author.equalsIgnoreCase("James")) {
//                details.add(new Detail("While we may not be able to control all that happens to us, we can control what happens inside us.", R.drawable.ability));
//            } else if (author.equalsIgnoreCase("Franklin")) {
//                details.add(new Detail("Knowledge is power, but enthusiasm pulls the switch.", R.drawable.ability));
//            } else if (author.equalsIgnoreCase("Emerson")) {
//                details.add(new Detail("The power which resides in man is new in nature, and none but he knows what that is which he can do, nor does he know until he has tried.", R.drawable.ability));
//            } else if (author.equalsIgnoreCase("Tracy")) {
//                details.add(new Detail("Your greatest asset is your earning ability. Your greatest resource is your time.", R.drawable.ability));
//            }
//
//        } else {
//            if (author.equalsIgnoreCase("Russell")) {
//                details.add(new Detail("To fear love is to fear life, and those who fear life are already three parts dead..", R.drawable.love));
//                details.add(new Detail("With self-discipline most anything is possible.", R.drawable.love));
//            } else if (author.equalsIgnoreCase("Thoreau")) {
//                details.add(new Detail("There is no remedy for love but to love more.", R.drawable.love));
//            } else if (author.equalsIgnoreCase("Shakespeare")) {
//                details.add(new Detail("She's gone. I am abused, and my relief must be to loathe her.", R.drawable.love));
//            } else if (author.equalsIgnoreCase("Emerson")) {
//                details.add(new Detail("A low self-love in the parent desires that his child should repeat his character and fortune.", R.drawable.love));
//            } else if (author.equalsIgnoreCase("Lennon")) {
//                details.add(new Detail("Love is a promise, love is a souvenir, once given never forgotten, never let it disappear.", R.drawable.love));
//            }
//        }
//
//
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(DetailQuote.this);
//
//        adapter = new DetailAdapter(this, details);
//
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(adapter);

    }
}
