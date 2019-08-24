package com.test.interview.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.test.interview.ui.main.MainActivity;
import com.test.interview.ui.main.MainFragmentBindingModule;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {MainFragmentBindingModule.class})
    abstract MainActivity bindMainActivity();
}
