package com.jake.andoridmvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * description： base of all activitys
 *
 * @author jake
 * @since 2016/10/23 22:02
 */


public class BaseActivity extends AppCompatActivity {
    protected int mActivityState = -1;
    protected static final int ACTIVITY_CREATE = 0x001;
    protected static final int ACTIVITY_RESUME = 0x002;
    protected static final int ACTIVITY_PAUSE = 0x003;
    protected static final int ACTIVITY_DESTROY = 0x004;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {//if child want to override this method,have to call super
        super.onCreate(savedInstanceState);
        mActivityState = ACTIVITY_CREATE;
    }

    @CallSuper
    @Override
    protected void onResume() {//if child want to override this method,have to call super
        super.onResume();
        mActivityState = ACTIVITY_RESUME;
    }

    @CallSuper
    @Override
    protected void onPause() {//if child want to override this method,have to call super
        super.onPause();
        mActivityState = ACTIVITY_PAUSE;
    }

    @CallSuper
    @Override
    protected void onDestroy() {//if child want to override this method,have to call super
        super.onDestroy();
        mActivityState = ACTIVITY_DESTROY;
    }

    protected View inflate(int layoutId, ViewGroup root, boolean attachToRoot) {
        return getLayoutInflater() != null ? getLayoutInflater().inflate(layoutId, root, attachToRoot) : null;
    }

    protected View inflate(int layoutId, ViewGroup root) {
        return inflate(layoutId, root, root != null);
    }

    protected View inflate(int layoutId) {
        return inflate(layoutId, null);
    }

    protected Activity getActivity() {
        return this;
    }

    /**
     * Return true if the activity is alive
     * @return
     */
    protected boolean isAlive() {
        return mActivityState != ACTIVITY_DESTROY && mActivityState != -1;
    }
}
