package com.example.quote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {

    private Context mContext ;
    private ArrayList<Detail> mQuoteList ;


    public DetailAdapter(Context mContext, ArrayList<Detail> mQuoteList) {
        this.mContext = mContext;
        this.mQuoteList = mQuoteList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.detail,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.quote.setText(mQuoteList.get(position).getQuote());
        holder.image.setImageResource(mQuoteList.get(position).getImage());

        holder.cname.setText(mQuoteList.get(position).getCname());
        holder.author.setText(mQuoteList.get(position).getAuthor());

        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Favourite.class);

                // passing data to the quote activity
                intent.putExtra("author",mQuoteList.get(position).getAuthor());
                intent.putExtra("cname",mQuoteList.get(position).getCname());
                intent.putExtra("quote",mQuoteList.get(position).getQuote());
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

        TextView quote;
        ImageView image;
        FrameLayout frameLayout;

        TextView cname;
        TextView author;

        public MyViewHolder(View itemView) {
            super(itemView);

            quote = (TextView) itemView.findViewById(R.id.tvQuote);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            frameLayout = itemView.findViewById(R.id.forebackground);

            cname = (TextView) itemView.findViewById(R.id.cname);
            author = (TextView) itemView.findViewById(R.id.author);


        }
    }


}