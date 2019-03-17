package com.example.hxx.test4.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends PagerAdapter {
    private List<View> viewList=new ArrayList<>();
    private List<String> titlelist=new ArrayList<>();

    public MyAdapter(List<View> viewList, List<String> titlelist) {
        this.viewList = viewList;
        this.titlelist = titlelist;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
}
