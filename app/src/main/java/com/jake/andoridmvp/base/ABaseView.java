package com.jake.andoridmvp.base;

import android.content.Context;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * description：base class of all views module
 *
 * @author jake
 * @since 2016/10/22 14:17
 */


public abstract class ABaseView<Presenter extends IBasePresenter> {
    protected View mContentView;
    protected Presenter mPresenter;

    public ABaseView(View contentView, Presenter presenter) {
        this.mContentView = contentView;
        mPresenter = presenter;
    }

    /**
     * init views
     */
    protected abstract void initViews();

    protected Context getContext() {
        return mContentView != null ? mContentView.getContext() : null;
    }

    protected View findViewById(int id) {
        return mContentView != null ? mContentView.findViewById(id) : null;
    }
}
