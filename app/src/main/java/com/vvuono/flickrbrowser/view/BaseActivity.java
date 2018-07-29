package com.vvuono.flickrbrowser.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vvuono.flickrbrowser.components.ActivityComponent;
import com.vvuono.flickrbrowser.components.DaggerActivityComponent;
import com.vvuono.flickrbrowser.modules.ActivityModule;
import com.vvuono.flickrbrowser.presenter.BaseMvpPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends BaseMvpPresenter>
        extends AppCompatActivity implements BaseView {
    @Inject T mPresenter;

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResource());
        ButterKnife.bind(this);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
        injectDependencies();
        mPresenter.attach(this);
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public T getPresenter() {
        return mPresenter;
    }

    @LayoutRes
    protected abstract int getContentResource();

    protected abstract void init(@Nullable Bundle state);

    protected abstract void injectDependencies();
}
