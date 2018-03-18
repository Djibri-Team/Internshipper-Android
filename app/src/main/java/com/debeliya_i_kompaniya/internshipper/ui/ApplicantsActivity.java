package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.debeliya_i_kompaniya.internshipper.DataProvider;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.UserAccount;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_applicants_recyclerview.all_offers_recyclerview.ApplicantListRecyclerViewAdapter;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_applicants_recyclerview.all_offers_recyclerview.OnClickApplicants;

import java.util.ArrayList;

import butterknife.BindView;


public class ApplicantsActivity extends BaseActivity {

    @BindView(R.id.rv_applicants) RecyclerView recyclerView;
    private Offer offer;
    private ArrayList<UserAccount> allApplicants = new ArrayList<>();

    private ApplicantListRecyclerViewAdapter adapter;

    public static Intent getIntent(Context context, Offer offer) {
        Intent intent = new Intent(context, ApplicantsActivity.class);
        intent.putExtra("offer", offer);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicants);
        configureRecyclerView();
        getExtras();
    }

    private void getExtras() {
        offer = getIntent().getParcelableExtra("offer");
    }

    private void configureRecyclerView() {
        adapter = new ApplicantListRecyclerViewAdapter(allApplicants, new OnClickApplicants() {
            @Override
            public void onClickApplicant(UserAccount userAccount, int position) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void getAllApplicants() {
        DataProvider.getInstance().getAllApplicants(this, offer.getId());
    }

    public void setDataToAdapter(ArrayList<UserAccount> userAccounts) {
        adapter.setData(userAccounts);
    }
}
