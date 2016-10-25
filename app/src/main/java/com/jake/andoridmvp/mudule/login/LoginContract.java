package com.jake.andoridmvp.mudule.login;

import android.view.View;

import com.jake.andoridmvp.base.ABaseView;
import com.jake.andoridmvp.base.IBasePresenter;
import com.jake.andoridmvp.model.ResponseCallback;
import com.jake.andoridmvp.entity.User;

/**
 * description：login module mvp contract
 *
 * @author jake
 * @since 2016/10/22 14:28
 */


public class LoginContract {
    interface IPresenter extends IBasePresenter {
        void login(String account, String pwd);
    }

    interface IModel {
        void login(String account, String pwd, ResponseCallback<User> callback);
    }

    public static abstract class AView<Presenter extends IBasePresenter> extends ABaseView<IPresenter> {

        public AView(View contentView, IPresenter presenter) {
            super(contentView, presenter);
        }

    }

}
