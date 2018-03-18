package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.debeliya_i_kompaniya.internshipper.DataProvider;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.BottomNavOptions;
import com.debeliya_i_kompaniya.internshipper.enums.UserRole;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class InternshipDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_position_name) TextView positionName;
    @BindView(R.id.tv_company_name) TextView companyName;
    @BindView(R.id.tv_category) TextView category;
    @BindView(R.id.tv_duration) TextView duration;
    @BindView(R.id.tv_working_hours) TextView workingHours;
    @BindView(R.id.ib_back_button) ImageButton btnBack;

    private Offer offer;

    @OnClick(R.id.ib_back_button)
        void getToPreviousPage() {
            if(DataProvider.getInstance().getUserAccount().getUserRole().equals(UserRole.EMPLOYER)) {
                startActivity(EmployerHomePageActivity.getIntent(this, BottomNavOptions.HOME));
            } else {
                startActivity(AllOffersActivity.getIntent(this, BottomNavOptions.HOME));
            }
        }

    public static Intent getIntent(Context context, Offer offer) {
        Intent intent = new Intent(context, InternshipDetailsActivity.class);
        intent.putExtra("offer", offer);

        return intent;
    }

//    public void setOfferValue() {
//        Intent intent = getIntent();
//
//        offer = intent.getParcelableExtra("offer");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship_details);

        getExtraArguments();
        configFields();
    }

    private void configFields() {
        positionName.setText(offer.getTitle());
        companyName.setText(offer.getCompanyName());
        category.setText(offer.getType().toString());
        duration.setText(offer.getInternTimeLength());
        workingHours.setText(offer.getWorkingHours());
    }

    private void getExtraArguments() {
        offer = getIntent().getParcelableExtra("offer");
    }
}
