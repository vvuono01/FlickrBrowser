package com.vvuono.flickrbrowser.modules;

import android.content.Context;

import com.vvuono.flickrbrowser.contracts.BrowserContract;
import com.vvuono.flickrbrowser.presenter.BrowserPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Context mContext;

    public ActivityModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    BrowserContract.Presenter providesBrowserPresenter() {
        return new BrowserPresenter();
    }
}
