package com.vvuono.flickrbrowser.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResource());
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    @LayoutRes
    protected abstract int getContentResource();

    protected abstract void init(@Nullable Bundle state);
}
