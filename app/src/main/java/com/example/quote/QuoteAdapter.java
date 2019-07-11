package com.example.quote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.MyViewHolder> {

    private Context mContext ;
    private ArrayList<Quote> mQuoteList ;


    public QuoteAdapter(Context mContext, ArrayList<Quote> mQuoteList) {
        this.mContext = mContext;
        this.mQuoteList = mQuoteList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.quote,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.author.setText(mQuoteList.get(position).getAuthor());
        holder.image.setImageResource(mQuoteList.get(position).getImage());

        holder.cName.setText(mQuoteList.get(position).getCname());

        String let = mQuoteList.get(position).getAuthor().substring(0,2);
        holder.letter.setText(let);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailQuote.class);

                // passing data to the quote activity
                intent.putExtra("cname",mQuoteList.get(position).getCname());
                intent.putExtra("author",mQuoteList.get(position).getAuthor());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mQuoteList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView author;
        ImageView image;
        TextView letter;
        CardView cardView;
        TextView cName;

        public MyViewHolder(View itemView) {
            super(itemView);

            author = (TextView) itemView.findViewById(R.id.author);
            letter = (TextView) itemView.findViewById(R.id.letter);
            image = (ImageView) itemView.findViewById(R.id.catImage);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);

            cName = (TextView) itemView.findViewById(R.id.cname);

        }
    }


}