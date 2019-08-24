package com.test.interview.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.test.interview.data.rest.ImageRepositoryService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    private static final String BASE_URL = "https://dl.dropboxusercontent.com/";

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static ImageRepositoryService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(ImageRepositoryService.class);
    }
}
