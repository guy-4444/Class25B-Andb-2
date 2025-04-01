package com.guyi.class25b_andb_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.view.menu.MenuBuilder;

import com.guyi.class25b_andb_2.databinding.ActivityMainBinding;
import com.guyi.common.MainActivity_Parent;
import com.guyi.common.PaymentUtil;

public class MainActivity extends MainActivity_Parent {

    private ActivityMainBinding binding;

    @Override
    public String getSuccessMessage() {
        return "Bit payment success";
    }

    @Override
    public String getErrorMessage() {
        return "Bit payment failed";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        AD_API = BuildConfig.ADMOB_APP_ID;
        banner = binding.lblBanner;
        imageView = binding.imgBackground;

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Bit");

        binding.btnPay.setOnClickListener(v -> payClicked());
    }

    private void payClicked() {
        binding.btnPay.setVisibility(View.INVISIBLE);
        int amount = Integer.parseInt(binding.edtAmount.getEditText().getText().toString());

        PaymentUtil.pay(amount, new PaymentUtil.PaymentCallback() {
            @Override
            public void onSuccess() {
                binding.anmCheck.setVisibility(View.VISIBLE);
                binding.anmCheck.playAnimation();
                binding.btnPay.setVisibility(View.VISIBLE);
                success();
            }

            @Override
            public void onError() {

            }
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_send) {
            menuClickedSend();
            return true;
        } else if (id == R.id.action_about) {
            menuClickedAbout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void menuClickedAbout() {

    }

    private void menuClickedSend() {

    }
}