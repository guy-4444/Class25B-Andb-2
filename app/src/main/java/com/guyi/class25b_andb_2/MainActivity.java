package com.guyi.class25b_andb_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import com.bumptech.glide.Glide;
import com.guyi.class25b_andb_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String AD_API;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Bit");

        binding.btnPay.setOnClickListener(v -> payClicked());

        setBackground(R.drawable.img_back);
        initBanner(AD_API);
    }

    private void initBanner(String api) {
        binding.lblBanner.setText(api);
    }

    private void setBackground(int res) {
        Glide
                .with(this)
                .load(res)
                .centerCrop()
                .into(binding.imgBackground);
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