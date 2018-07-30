package com.vvuono.flickrbrowser.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.vvuono.flickrbrowser.R;
import com.vvuono.flickrbrowser.contracts.BrowserContract;
import com.vvuono.flickrbrowser.presenter.BrowserPresenter;
import com.vvuono.flickrbrowser.view.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class BrowserActivity extends BaseActivity<BrowserPresenter> implements BrowserContract.View {
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
    public void onImagesLoaded(List<String> imageData) {
        // TODO: Send URLs to adapter
    }
}
