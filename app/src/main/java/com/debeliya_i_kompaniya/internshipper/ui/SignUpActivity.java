package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.debeliya_i_kompaniya.internshipper.DataProvider;
import com.debeliya_i_kompaniya.internshipper.InternshipperApplication;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.BottomNavOptions;
import com.debeliya_i_kompaniya.internshipper.enums.UserRole;
import com.debeliya_i_kompaniya.internshipper.models.UserAccount;
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
    @BindView(R.id.cb_user_role) CheckBox userRoleCheckBox;

    @OnClick(R.id.btn_signup)
    void userSignUp() {
        if(checkIfFieldsAreEmpty()) {
            checkIfPasswordsMatch();
        } else {
            UserAccount userAccount = getDataFromFields();
            if(DataProvider.getInstance().registerUser(userAccount)) {
                startActivity(MyOfferListActivity.getIntent(this, BottomNavOptions.HOME));
            }
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

    public UserAccount getDataFromFields() {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        UserRole userRole;
        if(userRoleCheckBox.isChecked()) {
            userRole = UserRole.EMPLOYER;
        } else {
            userRole = UserRole.STUDENT;
        }

        return new UserAccount(firstName, lastName, email, password, userRole.toString());
    }
}
