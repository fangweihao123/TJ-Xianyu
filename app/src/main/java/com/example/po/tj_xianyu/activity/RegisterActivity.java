package com.example.po.tj_xianyu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.po.tj_xianyu.R;
import com.example.po.tj_xianyu.service.verifyservice.VerifyService;
import com.example.po.tj_xianyu.service.webservice.HttpService;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 13701 on 2017/12/28.
 */

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.tv_account) EditText account;
    @BindView(R.id.input_account) TextInputLayout accountLayout;
    @BindView(R.id.tv_user_name)  EditText userName;
    @BindView(R.id.input_user_name) TextInputLayout userNameLayout;
    @BindView(R.id.tv_password)  EditText password;
    @BindView(R.id.input_password) TextInputLayout passwordLayout;
    @BindView(R.id.tv_confirm_password)  EditText confirmPassword;
    @BindView(R.id.input_confirm_password) TextInputLayout confirmPasswordLayout;
    @BindView(R.id.btn_register) Button registerButton;
    @BindView(R.id.redirect_to_login) Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initButton();
        super.onCreate(savedInstanceState);
    }

    private void initButton(){
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerifyService verifyService = new VerifyService();
                boolean cancel = false;
                View focusView = null;

                String mAccount = account.getText().toString();
                String mUserName = userName.getText().toString();
                String mPassword = password.getText().toString();
                String mConfirmPassword = confirmPassword.getText().toString();

                if(TextUtils.isEmpty(mAccount)){
                    accountLayout.setError(getString(R.string.error_register_no_account));
                    focusView = account;
                    cancel = true;
                }else if(!verifyService.isEmailValid(mAccount)&&!verifyService.isPhoneValid(mAccount)){
                    accountLayout.setError(getString(R.string.error_invalid_name));
                    focusView = account;
                    cancel = true;
                }else if(TextUtils.isEmpty(mUserName)){
                    userNameLayout.setError(getString(R.string.error_no_user_name));
                    focusView = userName;
                    cancel = true;
                }else if(TextUtils.isEmpty(mPassword)){
                    passwordLayout.setError(getString(R.string.error_no_password));
                    focusView = password;
                    cancel = true;
                }else if(!mPassword.equals(mConfirmPassword)){
                    confirmPasswordLayout.setError(getString(R.string.error_password_inconsistent));
                    focusView = confirmPassword;
                    cancel = true;
                }

                if(cancel){
                    focusView.requestFocus();
                }else{
                    RequestBody requestBody = new FormBody.Builder()
                            .add("acc",mAccount).add("user_name",mUserName)
                            .add("psw",mPassword).build();
                    HttpService.sendOkHttpRequest("Register", requestBody, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                   // Toast.makeText(RegisterActivity.this,"register success",Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
