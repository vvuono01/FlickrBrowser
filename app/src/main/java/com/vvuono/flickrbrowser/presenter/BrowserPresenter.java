package com.vvuono.flickrbrowser.presenter;

import com.vvuono.flickrbrowser.contracts.BrowserContract;

import javax.inject.Inject;

public class BrowserPresenter extends BasePresenter<BrowserContract.View>
        implements BrowserContract.Presenter {
    @Inject
    public BrowserPresenter() {}

    @Override
    public void loadImages() {
        getView().onImagesLoaded("TEST PRESENTER DATA");
    }
}
