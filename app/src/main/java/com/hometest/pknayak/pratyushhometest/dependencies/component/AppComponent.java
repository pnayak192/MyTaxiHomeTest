package com.hometest.pknayak.pratyushhometest.dependencies.component;

import com.hometest.pknayak.pratyushhometest.activities.AuthenticatedActivity;
import com.hometest.pknayak.pratyushhometest.activities.AuthenticationActivity;
import com.hometest.pknayak.pratyushhometest.activities.MainActivity;
import com.hometest.pknayak.pratyushhometest.dependencies.module.NetworkModule;
import com.hometest.pknayak.pratyushhometest.dependencies.module.PermissionModule;
import com.hometest.pknayak.pratyushhometest.dependencies.module.SharedPrefStorageModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, PermissionModule.class, SharedPrefStorageModule.class})
public interface AppComponent {

    void inject(AuthenticatedActivity activity);

    void inject(MainActivity activity);

    void inject(AuthenticationActivity activity);

}
