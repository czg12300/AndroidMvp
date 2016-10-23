package com.jake.andoridmvp.mudule.login;

import android.text.TextUtils;

import com.jake.andoridmvp.model.ResponseCallback;
import com.jake.andoridmvp.mudule.login.entity.User;

/**
 * description：logic of login
 *
 * @author jake
 * @since 2016/10/23 22:57
 */


public class LoginModel implements LoginContract.IModel {
    @Override
    public void login(String account, String pwd, ResponseCallback<User> callback) {
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(pwd) && TextUtils.equals("1", account)) {
            User user = new User();
            user.nickname = "jake";
            user.sex = 1;
            user.avatar = "http://iloveu.jake.png";
            user.token = "asfasgdsge22553sdgage6";
            if (callback != null) {
                callback.onSuccess(user);
            }
        } else {
            if (callback != null) {
                callback.onFail(-1, "login fail");
            }
        }
    }
}
