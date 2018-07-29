package com.vvuono.flickrbrowser.presenter;

import com.vvuono.flickrbrowser.view.BaseView;

public interface BaseMvpPresenter<V extends BaseView> {
    void attach(V view);
    void detach();
    boolean isAttached();
}
