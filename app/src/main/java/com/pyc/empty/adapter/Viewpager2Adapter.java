package com.pyc.empty.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pyc.empty.R;

import java.util.ArrayList;
import java.util.List;


public class Viewpager2Adapter
        extends RecyclerView.Adapter<Viewpager2Adapter.Viewpager2ViewHolder> {

    private List<String> titles = new ArrayList<>();

    public Viewpager2Adapter(){
        titles.add("title one");
        titles.add("title two");
        titles.add("title three");
        titles.add("title four");
        titles.add("title five");
    }

    @NonNull
    @Override
    public Viewpager2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewpager2ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewpager2ViewHolder holder, int position) {
        holder.mTv.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class Viewpager2ViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;
        RelativeLayout mContainer;

        public Viewpager2ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.container);
            mTv = itemView.findViewById(R.id.tvTitle);
        }
    }
}
