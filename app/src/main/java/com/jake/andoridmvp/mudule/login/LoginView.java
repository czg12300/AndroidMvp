package com.jake.andoridmvp.mudule.login;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jake.andoridmvp.R;

/**
 * description：
 *
 * @author jake
 * @since 2016/10/23 22:18
 */


public class LoginView extends LoginContract.AView<LoginContract.IPresenter> {
    private EditText mEvAccount;
    private EditText mEvPwd;
    private Button mBtnLogin;
    private ProgressDialog mProgressDialog;

    public LoginView(View contentView, LoginContract.IPresenter presenter) {
        super(contentView, presenter);
    }

    @Override
    protected void initViews() {
        mEvAccount = (EditText) findViewById(R.id.ev_account);
        mEvPwd = (EditText) findViewById(R.id.ev_pwd);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginLoadView();
                mBtnLogin.setEnabled(false);
                mBtnLogin.setText("Login...");

            }
        });
    }

    private void showLoginLoadView() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        mProgressDialog.show();
    }


    public void onDestroy() {
        hideLoadDialog();
    }


    public void loginSuccess() {
        hideLoadDialog();
        mEvAccount.getText().clear();
        mEvPwd.getText().clear();
        mBtnLogin.setEnabled(true);
        mBtnLogin.setText("Login In");
    }

    public void loginFail() {
        hideLoadDialog();
        mBtnLogin.setEnabled(true);
        mBtnLogin.setText("Login In");
    }

    private void hideLoadDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
