package com.example.thienpro.mvp_firebase.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.thienpro.mvp_firebase.R;
import com.example.thienpro.mvp_firebase.databinding.ActivityRegisterBinding;
import com.example.thienpro.mvp_firebase.presenter.Impl.RegisterPresenterImpl;
import com.example.thienpro.mvp_firebase.presenter.RegistrerPresenter;
import com.example.thienpro.mvp_firebase.view.RegisterView;

/**
 * Created by ThienPro on 11/9/2017.
 */

public class RegisterActivity extends AppCompatActivity implements RegisterView {
    private ActivityRegisterBinding binding;
    private RegistrerPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setEvent(this);
        presenter = new RegisterPresenterImpl(this, this);
    }

    @Override
    public void navigationToVerifiEmail(Context context) {
        Intent intent = new Intent(context, VerifiEmailActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onRegisterClick() {
        if (TextUtils.isEmpty(binding.etEmail.getText()) || TextUtils.isEmpty(binding.etPassword.getText()) ||
                TextUtils.isEmpty(binding.etRepassword.getText()) || TextUtils.isEmpty(binding.etName.getText()) ||
                TextUtils.isEmpty(binding.etAddress.getText()))
            Toast.makeText(this, "Không được để trống các trường!", Toast.LENGTH_SHORT).show();
        if (binding.etName.getText().toString().length() >= 30)
            Toast.makeText(this, "Tên có độ dài dưới 30 ký tự!", Toast.LENGTH_SHORT).show();
        if (TextUtils.equals(binding.etPassword.getText(), binding.etRepassword.getText()))
            presenter.register(binding.etEmail.getText().toString(), binding.etPassword.getText().toString(), binding.etName.getText().toString(), binding.etAddress.getText().toString(), binding.rbNam.isChecked());
        else Toast.makeText(this, "Mật khẩu không trùng khớp!", Toast.LENGTH_SHORT).show();
    }

    public void onRegisterEmailFail(Context context) {
        Toast.makeText(context, "Địa chỉ email không dúng!", Toast.LENGTH_SHORT).show();
    }
}
