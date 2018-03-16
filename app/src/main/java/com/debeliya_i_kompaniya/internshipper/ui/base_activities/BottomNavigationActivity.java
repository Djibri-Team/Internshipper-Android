package com.debeliya_i_kompaniya.internshipper.ui.base_activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.StartConstants;

public abstract class BottomNavigationActivity extends BaseActivity {
    BottomNavigationView bottomNavigationView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        initBottomNavigation();
        addControlToBottomNavigation();
    }

    private void initBottomNavigation() {
        Intent intent = getIntent();

        int bottomNavOption = intent.getIntExtra(StartConstants.EXTRA_NAV_OPTION, 0);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        setSelectedBottomNavOption(bottomNavOption);
    }

    protected void setSelectedBottomNavOption(int bottomNavOption) {
        bottomNavigationView.setSelectedItemId(bottomNavOption);
    }

    private void addControlToBottomNavigation() {

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.nav_button_list:
                                //TODO : IMPLEMENT ME!
                                break;

                            case R.id.nav_button_home:
                                //TODO: IMPLEMENT ME!
                                break;

                            case R.id.nav_button_profile:
                                //TODO: IMPLEMENT ME!
                                break;
                        }

                        finish();
                        return true;
                    }
                });
    }
}
