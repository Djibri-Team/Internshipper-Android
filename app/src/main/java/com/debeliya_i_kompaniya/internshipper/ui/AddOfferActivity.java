package com.debeliya_i_kompaniya.internshipper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.dd.CircularProgressButton;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AddOfferActivity extends BaseActivity {
    @BindView(R.id.et_position) EditText etJobPosition;
    @BindView(R.id.et_company) EditText etCompanyName;
    @BindView(R.id.et_duration) EditText etDuration;
    @BindView(R.id.et_working_hours) EditText etWorkingHours;
    @BindView(R.id.et_description) EditText etDescription;
    @BindView(R.id.rb_software) RadioButton rbSoftware;
    @BindView(R.id.rb_hardware) RadioButton rbHardware;
    @BindView(R.id.rb_embedded) RadioButton rbEmbedded;
    @BindView(R.id.btn_add_offer) Button btnAddOffer;

    @OnClick(R.id.btn_add_offer)
    void addOffer() {
        checkIfFieldsAreEmpty();
    }

    private void checkIfFieldsAreEmpty() {
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
    }
}
