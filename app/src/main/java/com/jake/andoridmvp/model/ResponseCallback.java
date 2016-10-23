package com.jake.andoridmvp.model;

/**
 * description：callback of load data  response
 *
 * @author jake
 * @since 2016/10/23 21:49
 */


public interface ResponseCallback<Response> {
    void onFail(int code, String msg);

    void onSuccess(Response response);
}
