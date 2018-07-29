package com.vvuono.flickrbrowser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.vvuono.flickrbrowser.contracts.BrowserContract;
import com.vvuono.flickrbrowser.presenter.BrowserPresenter;
import com.vvuono.flickrbrowser.view.BaseActivity;

import butterknife.BindView;

public class BrowserActivity extends BaseActivity<BrowserPresenter> implements BrowserContract.View {
    @BindView(R.id.tv_test) TextView mTestText;

    @Override
    protected int getContentResource() {
        return R.layout.activity_browser;
    }

    @Override
    protected void init(@Nullable Bundle state) {
        getPresenter().loadImages();
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onImagesLoaded(String imageData) {
        mTestText.setText(imageData);
    }
}
