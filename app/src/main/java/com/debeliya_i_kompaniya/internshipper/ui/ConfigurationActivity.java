package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ConfigurationActivity extends BaseActivity {

    @BindView(R.id.btn_setup) Button setupBtn;
    @BindView(R.id.et_config)
    EditText etConfig;

    @OnClick(R.id.et_config)
    void setup() {
        SharedPreferences sharedPreferences = getSharedPreferences("Setup", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("url", etConfig.getText().toString());
        editor.apply();

        startActivity(new Intent(this, LoginActivity.class));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
    }
}
