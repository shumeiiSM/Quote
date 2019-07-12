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

import java.util.ArrayList;


public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.MyViewHolder> {

    private Context mContext ;
    private ArrayList<ShowClass> mCatList ;


    public ShowAdapter(Context mContext, ArrayList<ShowClass> mCatList) {
        this.mContext = mContext;
        this.mCatList = mCatList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.show,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.quote.setText(mCatList.get(position).getQuote());
        holder.category.setText(mCatList.get(position).getCategory());
        holder.author.setText(mCatList.get(position).getAuthor());

        holder.image.setImageResource(mCatList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return mCatList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView quote;
        TextView category;
        TextView author;
        ImageView image;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            quote = (TextView) itemView.findViewById(R.id.quote);
            category = (TextView) itemView.findViewById(R.id.category);
            author = (TextView) itemView.findViewById(R.id.author);
            image = (ImageView) itemView.findViewById(R.id.catImage);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);



        }
    }


}