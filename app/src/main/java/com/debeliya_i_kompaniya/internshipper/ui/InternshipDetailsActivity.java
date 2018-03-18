package com.debeliya_i_kompaniya.internshipper.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;

import butterknife.BindView;

public class InternshipDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_position_name) TextView positionName;
    @BindView(R.id.tv_company_name) TextView companyName;
    @BindView(R.id.tv_category) TextView category;
    @BindView(R.id.tv_duration) TextView duration;
    @BindView(R.id.tv_working_hours) TextView workingHours;

    private Offer offer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship_details);

        getExtraArguments();
        configFields();
    }

    private void configFields() {
        positionName.setText(offer.getTitle());
        companyName.setText(offer.getCompany());
        category.setText(offer.getType().toString());
        duration.setText(offer.getDuration());
        workingHours.setText(offer.getWorkingHours());
    }

    private void getExtraArguments() {
        offer = getIntent().getParcelableExtra("offer");
    }
}
