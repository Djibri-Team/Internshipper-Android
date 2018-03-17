package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.debeliya_i_kompaniya.internshipper.InternshipperApplication;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {
    @BindView(R.id.et_first_name) EditText etFirstName;
    @BindView(R.id.et_last_name) EditText etLastName;
    @BindView(R.id.et_email) EditText etEmail;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.et_confirm_password) EditText etConfirmPassword;
    @BindView(R.id.btn_signup) CircularProgressButton btnSignUp;
    @BindView(R.id.tv_signin) TextView tvSignIn;

    @OnClick(R.id.btn_signup)
    void userSignUp() {
        if(checkIfFieldsAreEmpty()) {
            checkIfPasswordsMatch();
        } else {
            //SIGN UP!!
        }
    }

    @OnClick(R.id.tv_signin)
    void transferToLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    private void checkIfPasswordsMatch() {
        if(!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
            InternshipperApplication.showToast("Passwords do not match!");

            etPassword.setText("");
            etConfirmPassword.setText("");
        }
    }

    private boolean checkIfFieldsAreEmpty() {
        if(etFirstName.getText().toString().equals("") ||
                etLastName.getText().toString().equals("") ||
                etEmail.getText().toString().equals("") ||
                etPassword.getText().toString().equals("") ||
                etConfirmPassword.getText().toString().equals("")) {

            InternshipperApplication.showToast("Please fill all the fields correctly!");
            return true;
        }
        return false;
    }
}
