package com.test.interview.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import com.test.interview.di.util.ViewModelKey;
import com.test.interview.ui.list.ImageListViewModel;
import com.test.interview.util.ViewModelFactory;

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ImageListViewModel.class)
    abstract ViewModel bindListViewModel(ImageListViewModel imageListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
