package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.StartConstants;
import com.debeliya_i_kompaniya.internshipper.models.User;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BottomNavigationActivity;

import butterknife.BindView;

public class UserProfileActivity extends BottomNavigationActivity {

    @BindView(R.id.et_user_firstname) EditText etFirstName;
    @BindView(R.id.et_user_lastname) EditText etLastName;
    @BindView(R.id.et_user_description) EditText etDescription;
    @BindView(R.id.et_user_email) EditText etEmail;
    @BindView(R.id.et_user_phone) EditText etPhone;

    public static Intent getIntent(Context context, int bottomNavOption) {
        Intent intent = new Intent(context, UserProfileActivity.class);
        intent.putExtra(StartConstants.EXTRA_NAV_OPTION, bottomNavOption);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String firstName = sharedPreferences.getString("firstName", "");
        String lastName  = sharedPreferences.getString("lastName", "");
        String description= sharedPreferences.getString("description", "");
        String email = sharedPreferences.getString("email", "");
        String phone = sharedPreferences.getString("phone", "");

        etFirstName.setText(firstName);
        etLastName.setText(lastName);
        etDescription.setText(description);
        etEmail.setText(email);
        etPhone.setText(phone);
    }
}
