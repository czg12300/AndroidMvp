package com.jake.andoridmvp.mudule.login;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.jake.andoridmvp.R;
import com.jake.andoridmvp.base.BaseActivity;
import com.jake.andoridmvp.model.ResponseCallback;
import com.jake.andoridmvp.mudule.login.entity.User;

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
        }, 800);

    }

    private void loginLogic(String account, String pwd) {
        mModel.login(account, pwd, new ResponseCallback<User>() {
            @Override
            public void onFail(int code, String msg) {
                if (mActivityState != ACTIVITY_DESTROY) {
                    mLoginView.loginFail();
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onSuccess(User user) {
                if (mActivityState != ACTIVITY_DESTROY) {
                    mLoginView.loginSuccess();
                    Toast.makeText(getActivity(), "login success," + user.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
