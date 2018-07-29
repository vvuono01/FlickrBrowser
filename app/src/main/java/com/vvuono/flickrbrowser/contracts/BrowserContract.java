package com.vvuono.flickrbrowser.contracts;

import com.vvuono.flickrbrowser.presenter.BaseMvpPresenter;
import com.vvuono.flickrbrowser.view.BaseView;

public class BrowserContract {
   public interface Presenter extends BaseMvpPresenter<BrowserContract.View> {
        void loadImages();
    }

    public interface View extends BaseView {
        void onImagesLoaded(String imageData); // TODO: Update this with actual imageData type
    }
}
