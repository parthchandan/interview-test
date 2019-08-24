package com.test.interview.ui.main;

import android.os.Bundle;

import com.test.interview.base.BaseActivity;

import com.test.interview.R;
import com.test.interview.ui.list.ImageListFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new ImageListFragment()).commit();
    }
}
