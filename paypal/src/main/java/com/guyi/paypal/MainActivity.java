package com.guyi.paypal;


import android.os.Bundle;
import android.view.View;


import com.guyi.common.MainActivity_Parent;
import com.guyi.common.PaymentUtil;
import com.guyi.paypal.databinding.ActivityMainBinding;

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

}