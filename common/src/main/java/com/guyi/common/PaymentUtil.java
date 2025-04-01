package com.guyi.common;

import android.os.Handler;
import android.os.Looper;

public class PaymentUtil {

    public interface PaymentCallback {
        void onSuccess();
        void onError();
    }

    public static void pay(int amount, PaymentCallback callback) {
        final Handler handler = new android.os.Handler(Looper.getMainLooper());
        handler.postDelayed(() -> callback.onSuccess(), 3000);

    }
}
