package com.hometest.pknayak.pratyushhometest.dependencies.module;

import com.hometest.pknayak.pratyushhometest.utils.PermissionHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PermissionModule {

    @Singleton
    @Provides
    PermissionHelper providePermissionHelper() {
        return new PermissionHelper();
    }

}
