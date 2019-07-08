package com.example.quote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.MyViewHolder> {

    private Context mContext ;
    private ArrayList<Cat> mCatList ;


    public CatAdapter(Context mContext, ArrayList<Cat> mCatList) {
        this.mContext = mContext;
        this.mCatList = mCatList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.category,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.name.setText(mCatList.get(position).getName());
        holder.image.setImageResource(mCatList.get(position).getImage());
        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ShowQuote.class);

                // passing data to the quote activity
                intent.putExtra("name",mCatList.get(position).getName());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mCatList.size();
    }

    public void removeItem(int position) {
        mCatList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Cat contact, int position) {
        mCatList.add(position, contact);
        notifyItemInserted(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;
        FrameLayout frameLayout ;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tvCategory) ;
            image = (ImageView) itemView.findViewById(R.id.imageView);
            frameLayout = (FrameLayout) itemView.findViewById(R.id.view_forebackground);


        }
    }


}