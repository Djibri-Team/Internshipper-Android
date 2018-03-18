package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.CircularProgressButton;
import com.debeliya_i_kompaniya.internshipper.DataProvider;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.BottomNavOptions;
import com.debeliya_i_kompaniya.internshipper.models.LoginModel;
import com.debeliya_i_kompaniya.internshipper.models.UserAccount;
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
    private String userRole;

    @OnClick(R.id.tv_signup)
    void startRegisterActivity() {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
    }

    @OnClick(R.id.btn_signIn)
    void signIn() {
        if (!checkIfFieldsAreEmpty()) {
            getUserDataFromFields();

            if(DataProvider.getInstance().loginUser(new LoginModel(email, password), this)) {
                Log.d("zax", "signIn: " + userRole);

            }
        }

    }

    public void getUserFromDatabase() {
        UserAccount userAccount = DataProvider.getInstance().getUserAccount();

        saveToSharedPreferences(userAccount);

        if (userRole.equals("EMPLOYER")) {
            startActivity(new Intent(this, EmployerHomePageActivity.class));
        }
        else {
            startActivity(MyOfferListActivity.getIntent(this, BottomNavOptions.OFFERLIST));
        }
    }

    private void saveToSharedPreferences(UserAccount userAccount) {
        Log.d("ZAX", "saveToSharedPreferences: " + userAccount.toString());

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstName", userAccount.getFirstName());
        editor.putString("lastName", userAccount.getLastName());
        editor.putString("email", userAccount.getEmail());
        editor.putString("password", userAccount.getPassword());
        editor.putString("userRole", userAccount.getUserRole().toString());

        userRole = userAccount.getUserRole().toString();

        editor.apply();

        Log.d("zax", "saveToSharedPreferences: " + userAccount.getUserRole().toString());
    }

    private boolean checkIfFieldsAreEmpty() {
        if (etEmail.getText().toString().equals("") || etPassword.getText().toString().equals("")) {
            return true;
        }
        return false;
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
