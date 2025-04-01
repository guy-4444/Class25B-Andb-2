package com.guyi.common;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

public abstract class MainActivity_Parent extends AppCompatActivity {

    protected String AD_API = "NA";
    protected MaterialTextView banner;
    protected AppCompatImageView imageView;

    public abstract String getSuccessMessage();
    public abstract String getErrorMessage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBanner(AD_API);
        setBackground(R.drawable.img_back, imageView);

    }

    private void setBackground(int res, AppCompatImageView imageView) {
        Glide
                .with(this)
                .load(res)
                .centerCrop()
                .into(imageView);
    }

    private void initBanner(String api) {
        banner.setText(api);
    }

    protected void success() {
        View rootView = findViewById(android.R.id.content);
        Snackbar.make(rootView, getSuccessMessage(), Snackbar.LENGTH_LONG).show();
    }
    protected void error() {
        View rootView = findViewById(android.R.id.content);
        Snackbar.make(rootView, getErrorMessage(), Snackbar.LENGTH_LONG)
                .setAction("close", v -> {}).show();
    }

}