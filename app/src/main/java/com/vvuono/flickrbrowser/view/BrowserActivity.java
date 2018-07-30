package com.vvuono.flickrbrowser.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.vvuono.flickrbrowser.R;
import com.vvuono.flickrbrowser.contracts.BrowserContract;
import com.vvuono.flickrbrowser.presenter.BrowserPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BrowserActivity extends BaseActivity<BrowserPresenter> implements BrowserContract.View {
    @BindView(R.id.vp_imagePager) ViewPager mViewPager;

    private ImageAdapter mImageAdapter;

    @Override
    protected int getContentResource() {
        return R.layout.activity_browser;
    }

    @Override
    protected void init(@Nullable Bundle state) {
        mImageAdapter = new ImageAdapter(this);
        mViewPager.setAdapter(mImageAdapter);

        getPresenter().loadImages();
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onImagesLoaded(List<String> imageData) {
        mImageAdapter.setImages(imageData);
        mImageAdapter.notifyDataSetChanged();
    }
}
