package com.hometest.pknayak.pratyushhometest;

import android.app.Application;
import android.content.Context;

import com.hometest.pknayak.pratyushhometest.dependencies.component.AppComponent;
import com.hometest.pknayak.pratyushhometest.dependencies.component.DaggerAppComponent;
import com.hometest.pknayak.pratyushhometest.dependencies.module.SharedPrefStorageModule;

public class App extends Application {

    private AppComponent mAppComponent;

    public static App getApplicationContext(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .sharedPrefStorageModule(new SharedPrefStorageModule(getApplicationContext()))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
