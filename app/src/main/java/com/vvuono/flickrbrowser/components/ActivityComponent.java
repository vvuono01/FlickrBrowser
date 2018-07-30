package com.vvuono.flickrbrowser.components;

import com.vvuono.flickrbrowser.view.BrowserActivity;
import com.vvuono.flickrbrowser.modules.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(BrowserActivity obj);
}
