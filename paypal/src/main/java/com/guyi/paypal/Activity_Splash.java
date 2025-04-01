package com.guyi.paypal;

import android.os.Bundle;

import com.guyi.common.Activity_SplashParent;

public class Activity_Splash extends Activity_SplashParent {

    @Override
    public int getLogoRes() {
        return R.drawable.ic_paypal;
    }

    @Override
    public Class<?> getClassToOpen() {
        return MainActivity.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
