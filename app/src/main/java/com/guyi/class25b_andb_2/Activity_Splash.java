package com.guyi.class25b_andb_2;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.guyi.common.Activity_SplashParent;

public class Activity_Splash extends Activity_SplashParent {

    @Override
    public int getLogoRes() {
        return R.drawable.ic_icon;
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
