package com.jake.andoridmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * description：
 *
 * @author jake
 * @since 2016/10/24 21:19
 */


public abstract class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    protected abstract void initViews();

    protected View findViewById(int id) {
        return getView() != null ? getView().findViewById(id) : null;
    }


    /**
     * Return true if the activity is alive
     *
     * @return
     */
    protected boolean isAlive() {
        return isAdded() && !isDetached() && !isRemoving() && getActivity() != null;
    }
}
