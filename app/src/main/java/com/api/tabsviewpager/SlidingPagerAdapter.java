package com.api.tabsviewpager;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by iSaleem on 8/8/17.
 */

public abstract class SlidingPagerAdapter<T> extends PagerAdapter {


    private final List<T> images;
    private LayoutInflater inflater;
    private Context context;
    int i;


    public SlidingPagerAdapter(Context context, final List<T> images) {
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "tap 1";
        } else if (position == 1) {
            return "tap 2";
        } else {
            return "tap 3";
        }
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {

        return initiateItem(inflater, view, position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public abstract View initiateItem(LayoutInflater inflater, ViewGroup view, int position);

}
