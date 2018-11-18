package com.hometest.pknayak.pratyushhometest.dependencies.module;

import com.hometest.pknayak.pratyushhometest.utils.network.HttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    HttpClient provideHttpClient() {
        return new HttpClient();
    }

}
