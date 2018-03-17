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
import com.debeliya_i_kompaniya.internshipper.models.User;
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
        if (!checkIfFieldsAreEmpty()) {
            getUserFromDatabase();
        }
        getUserFromDatabase();
        getUserDataFromFields();
        //TODO: Implement this!

        startActivity(MyOfferListActivity.getIntent(this, BottomNavOptions.OFFERLIST));
    }

    private void getUserFromDatabase() {
        User user = DataProvider.getInstance().getUser();

        saveToSharedPreferences(user);
    }

    private void saveToSharedPreferences(User user) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstName", user.getFirstName());
        editor.putString("lastName", user.getLastName());
        editor.putString("email", user.getEmail());
        editor.putString("password", user.getPassword());
        editor.putString("userRole", user.getUserRole().toString());

        editor.apply();

        Log.d("zax", "saveToSharedPreferences: " + user.getUserRole().toString());
    }

    private boolean checkIfFieldsAreEmpty() {
        if (etEmail.getText().toString().equals("") || etPassword.getText().toString().equals("")) {
            return true;
        }
        else {
            return false;
        }
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
