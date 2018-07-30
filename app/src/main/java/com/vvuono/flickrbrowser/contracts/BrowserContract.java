package com.vvuono.flickrbrowser.contracts;

import com.vvuono.flickrbrowser.presenter.BaseMvpPresenter;
import com.vvuono.flickrbrowser.view.BaseView;

import java.util.List;

public class BrowserContract {
   public interface Presenter extends BaseMvpPresenter<BrowserContract.View> {
        void loadImages();
    }

    public interface View extends BaseView {
        void onImagesLoaded(List<String> imageData);
    }
}
