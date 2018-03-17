package com.debeliya_i_kompaniya.internshipper.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.StartConstants;
import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BottomNavigationActivity;
import com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview.OnClickMyOffer;
import com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview.MyOfferListRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class MyOfferListActivity extends BottomNavigationActivity {
    @BindView(R.id.rv_my_offers) RecyclerView recyclerView;
    @BindView(R.id.btn_apply_now) Button btnApplyNow;
    @BindView(R.id.not_applied_text) TextView tvNotApplied;
    private MyOfferListRecyclerViewAdapter adapter;

    public static  Intent getIntent(Context context, int bottomNavOption) {
        Intent intent = new Intent(context, MyOfferListActivity.class);
        intent.putExtra(StartConstants.EXTRA_NAV_OPTION, bottomNavOption);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_offer_list);

        configureRecyclerView();
    }

    private void configureRecyclerView() {
        ArrayList<OfferWithStatus> myOffers = getMyOffers();
        if(myOffers.size() > 0 ) {
            hideNotAppliedView();
        }

        adapter = new MyOfferListRecyclerViewAdapter(getMyOffers(), new OnClickMyOffer() {
            @Override
            public void onOfferClick(OfferWithStatus offer, int position) {
                //TODO: IMPLEMENT ME!
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void hideNotAppliedView() {
        btnApplyNow.setVisibility(View.GONE);
        tvNotApplied.setVisibility(View.GONE);
        displayRecyclerView();
    }

    private void displayRecyclerView() {
        recyclerView.setVisibility(View.VISIBLE);
    }

    private ArrayList<OfferWithStatus> getMyOffers() {
        ArrayList<OfferWithStatus> myOffers= new ArrayList<>();
        myOffers.add(new OfferWithStatus(new Offer(
                "Software engineer",
                "Melon AD",
                "2 weeks",
                "8 hours",
                "Cool meme",
                JobCategory.SOFTWARE),
                "PENDING"));
        //TODO: IMPLEMENT ME!

        return myOffers;
    }

}
