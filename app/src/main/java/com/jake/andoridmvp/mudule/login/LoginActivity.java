package com.jake.andoridmvp.mudule.login;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.jake.andoridmvp.R;
import com.jake.andoridmvp.base.BaseActivity;
import com.jake.andoridmvp.model.ResponseCallback;
import com.jake.andoridmvp.mudule.login.entity.User;

import java.util.concurrent.Future;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.plugins.RxAndroidPlugins;

/**
 * description：
 *
 * @author jake
 * @since 2016/10/22 14:26
 */


public class LoginActivity extends BaseActivity implements LoginContract.IPresenter {
    private LoginView mLoginView;
    private LoginContract.IModel mModel;
    private Handler mTestHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        View contentView = inflate(R.layout.activity_login);
        setContentView(contentView);
        mLoginView = new LoginView(contentView, this);
        mModel = new LoginModel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginView.onDestroy();
    }

    @Override
    public void login(final String account, final String pwd) {
        mTestHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loginLogic(account, pwd);
            }
        }, 5000);

    }

    private Observer<User> mObserver = new Observer<User>() {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(User user) {

        }
    };
    private Subscriber<User> mSubscriber = new Subscriber<User>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(User user) {

        }
    };

    private void loginLogic(String account, String pwd) {

        mModel.login(account, pwd, new ResponseCallback<User>() {
            @Override
            public void onFail(int code, String msg) {
                if (isAlive()) {
                    mLoginView.loginFail();
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSuccess(User user) {
                if (isAlive()) {
                    mLoginView.loginSuccess();
                    Toast.makeText(getActivity(), "login success," + user.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
