package com.jake.andoridmvp;

import android.app.Application;

/**
 * description：mvp demo's application
 *
 * @author jake
 * @since 2016/10/23 22:37
 */


public class MvpApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppController.getInstance().install(this);
    }
}
