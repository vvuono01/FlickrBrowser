package com.vvuono.flickrbrowser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.vvuono.flickrbrowser.contracts.BrowserContract;
import com.vvuono.flickrbrowser.presenter.BrowserPresenter;
import com.vvuono.flickrbrowser.view.BaseActivity;

import butterknife.BindView;

public class BrowserActivity extends BaseActivity implements BrowserContract.View {
    @BindView(R.id.tv_test) TextView mTestText;

    private BrowserPresenter mPresenter;

    @Override
    protected int getContentResource() {
        return R.layout.activity_browser;
    }

    @Override
    protected void init(@Nullable Bundle state) {
        mPresenter = new BrowserPresenter(); // TODO: Replace this with dependency injection
        mPresenter.attach(this);
        mPresenter.loadImages();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    @Override
    public void onImagesLoaded(String imageData) {
        mTestText.setText(imageData);
    }
}
