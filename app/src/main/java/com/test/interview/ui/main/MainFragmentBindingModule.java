package com.test.interview.ui.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.test.interview.ui.list.ImageListFragment;

@Module
public abstract class MainFragmentBindingModule {

    @ContributesAndroidInjector
    abstract ImageListFragment provideListFragment();
}
