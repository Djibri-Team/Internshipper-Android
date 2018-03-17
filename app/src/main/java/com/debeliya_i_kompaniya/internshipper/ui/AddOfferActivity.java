package com.debeliya_i_kompaniya.internshipper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dd.CircularProgressButton;
import com.debeliya_i_kompaniya.internshipper.InternshipperApplication;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.BottomNavOptions;
import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AddOfferActivity extends BaseActivity {
    @BindView(R.id.et_position) EditText etJobPosition;
    @BindView(R.id.et_company) EditText etCompanyName;
    @BindView(R.id.et_duration) EditText etDuration;
    @BindView(R.id.et_working_hours) EditText etWorkingHours;
    @BindView(R.id.et_description) EditText etDescription;
    @BindView(R.id.rg_category) RadioGroup radioGroup;
    @BindView(R.id.rb_software) RadioButton rbSoftware;
    @BindView(R.id.rb_hardware) RadioButton rbHardware;
    @BindView(R.id.rb_embedded) RadioButton rbEmbedded;
    @BindView(R.id.btn_add_offer) Button btnAddOffer;
    @BindView(R.id.ib_back_button) ImageButton btnBack;

    @OnClick(R.id.ib_back_button)
    void goBackToAllOffers() {
        startActivity(AllOffers.getIntent(this, BottomNavOptions.OFFERLIST));
    }

    private RadioButton rb;

    private JobCategory jobCategory;

    private boolean isCategorySet = false;

    @OnClick(R.id.btn_add_offer)
    void addOffer() {
        if (!checkIfFieldsAreEmpty()) {
            saveOfferToDatabase(createOffer());

            startActivity(AllOffers.getIntent(this, BottomNavOptions.OFFERLIST));
            finish();
        }
    }

    private void saveOfferToDatabase(Offer offer) {
    }

    private Offer createOffer() {

        String title = etJobPosition.getText().toString();
        String companyName = etCompanyName.getText().toString();
        String duration = etDuration.getText().toString();
        String workingHours = etWorkingHours.getText().toString();
        String description = etDescription.getText().toString();
        JobCategory category = jobCategory;

        Offer offer = new Offer(title, companyName, duration, workingHours, description, category);

        return offer;
    }

    public void rbClick(View v) {
        int radioButtonID = radioGroup.getCheckedRadioButtonId();

        rb = findViewById(radioButtonID);

        jobCategory = JobCategory.stringToJobCategory(rb.getText().toString());
        isCategorySet = true;
    }

    private boolean checkIfFieldsAreEmpty() {
        if(etJobPosition.getText().toString().equals("") ||
                etCompanyName.getText().toString().equals("") ||
                etDuration.getText().toString().equals("") ||
                etWorkingHours.getText().toString().equals("") ||
                etDescription.getText().toString().equals("") ||
                !isCategorySet) {

//            InternshipperApplication.showToast("Please fill out all required fields!");
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
    }
}
