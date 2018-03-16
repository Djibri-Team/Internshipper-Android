package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.BottomNavOptions;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_email) EditText etEmail;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.btn_signIn)
    CircularProgressButton btnSignIn;
    @BindView(R.id.tv_signup)
    TextView tvSignUp;

    private String email;
    private String password;

    @OnClick(R.id.tv_signup)
    void startRegisterActivity() {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
    }

    @OnClick(R.id.btn_signIn)
    void signIn() {
        getUserDataFromFields();
        //TODO: Implement this!

        startActivity(OfferListActivity.getIntent(this, BottomNavOptions.OFFERLIST));
    }

    private void getUserDataFromFields() {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
