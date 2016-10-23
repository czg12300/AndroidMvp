package com.jake.andoridmvp;

import android.content.Context;

public class AppController {
    private Context context;


    public static AppController getInstance() {
        return InstanceBuilder.instance;
    }

    public void install(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    private static class InstanceBuilder {
        protected static AppController instance = new AppController();
    }
}
