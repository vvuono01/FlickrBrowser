package com.vvuono.flickrbrowser.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;
import com.vvuono.flickrbrowser.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageAdapter extends PagerAdapter {
    @BindView(R.id.iv_image) ImageView mImageView;

    private Activity mActivity;
    private List<String> mImages;

    public ImageAdapter(Activity activity) {
        mActivity = activity;
    }

    public void setImages(List<String> images) {
        mImages = images;
    }

    @Override
    public int getCount() {
        return mImages != null ? mImages.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_image, container, false);
        ButterKnife.bind(this, viewLayout);

        if (getCount() > 0) {
            Picasso.get().load(mImages.get(position)).into(mImageView);
        }

        container.addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
