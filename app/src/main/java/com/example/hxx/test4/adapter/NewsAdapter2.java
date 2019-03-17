package com.example.hxx.test4.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hxx.test4.R;
import com.example.hxx.test4.news.News;
import com.example.hxx.test4.tools.MyImageView;

import java.util.List;

public class NewsAdapter2 extends RecyclerView.Adapter<NewsAdapter2.ViewHolder> {
    private List<News.Newslist> mlist;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title2;
        TextView description2;
        MyImageView imageView2;
        View newsview;

        public ViewHolder(View view){
            super(view);
            title2=view.findViewById(R.id.title2);
            description2=view.findViewById(R.id.description2);
            imageView2=view.findViewById(R.id.image2);

        }
    }

    public NewsAdapter2(List<News.Newslist> newslists) {
        mlist=newslists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        News.Newslist newslist=mlist.get(i);
        viewHolder.title2.setText(newslist.getTitle());
        viewHolder.description2.setText(newslist.getDescription());
        viewHolder.imageView2.setImageURL(newslist.getPicUrl());
        Log.e("MainActivity",viewHolder.title2.getText().toString());
        View itemView = ((LinearLayout) viewHolder.itemView).getChildAt(0);

        if (mOnItemClickListener != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(viewHolder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}

