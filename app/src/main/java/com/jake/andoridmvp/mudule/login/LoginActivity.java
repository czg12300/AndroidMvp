package com.jake.andoridmvp.mudule.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jake.andoridmvp.R;
import com.jake.andoridmvp.base.BaseActivity;
import com.jake.andoridmvp.model.ResponseCallback;
import com.jake.andoridmvp.entity.User;



/**
 * description：
 *
 * @author jake
 * @since 2016/10/22 14:26
 */


public class LoginActivity extends BaseActivity implements LoginContract.IPresenter {
    private LoginView mLoginView;
    private LoginContract.IModel mModel;

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
    public void login(final String account, final String pwd) {
        loginLogic(account, pwd);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginView.onDestroy();
    }


    private void loginLogic(String account, String pwd) {
        mModel.login(account, pwd, new ResponseCallback<User>() {
            @Override
            public void onFail(int code, final String msg) {
                if (isAlive()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mLoginView.loginFail();
                            Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            @Override
            public void onSuccess(final User user) {
                if (isAlive()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mLoginView.loginSuccess();
                            Toast.makeText(getActivity(), "login success," + user.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
    }
}
