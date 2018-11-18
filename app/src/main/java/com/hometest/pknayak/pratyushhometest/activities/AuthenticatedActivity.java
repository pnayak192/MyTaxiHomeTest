package com.hometest.pknayak.pratyushhometest.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hometest.pknayak.pratyushhometest.App;
import com.hometest.pknayak.pratyushhometest.dependencies.component.AppComponent;
import com.hometest.pknayak.pratyushhometest.utils.storage.SharedPrefStorage;

import javax.inject.Inject;

public class AuthenticatedActivity extends AppCompatActivity {

    @Inject
    SharedPrefStorage mSharedPrefStorage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent = App.getApplicationContext(this).getAppComponent();
        appComponent.inject(this);
    }

    protected boolean isAuthenticated() {
        return mSharedPrefStorage.loadUser() != null;
    }

}
