package com.vvuono.flickrbrowser.presenter;

import com.vvuono.flickrbrowser.contracts.BrowserContract;

public class BrowserPresenter extends BasePresenter<BrowserContract.View>
        implements BrowserContract.Presenter {
    @Override
    public void loadImages() {
        getView().onImagesLoaded("TEST DATA");
    }
}
