package com.example.thienpro.mvp_firebase.view;

import android.content.Context;

/**
 * Created by ThienPro on 11/28/2017.
 */

public interface VerifiEmailView {
    void sendverifiEmailComplete(String email);
    void sendverifiEmailFail(String email);
    void navigationToHome(Context context);

    void onCancelClick();
    void onNextClick();
}
