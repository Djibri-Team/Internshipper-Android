package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.StartConstants;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BottomNavigationActivity;
import com.debeliya_i_kompaniya.internshipper.view_utils.OfferListRecyclerViewAdapter;
import com.debeliya_i_kompaniya.internshipper.view_utils.OnClickOffer;

import java.util.ArrayList;

import butterknife.BindView;

public class AllOffers extends BottomNavigationActivity {
    @BindView(R.id.rv_all_offers) RecyclerView recyclerView;
    private OfferListRecyclerViewAdapter adapter;

    public static Intent getIntent(Context context, int bottomNavOption) {
        Intent intent = new Intent(context, AllOffers.class);
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
        adapter = new OfferListRecyclerViewAdapter(getAllOffers(), new OnClickOffer() {
            @Override
            public void onOfferClick(Offer offer, int position) {
                //TODO IMPLEMENT ME!
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Offer> getAllOffers() {
        return null;
        //TODO: IMPLEMENT ME!
    }
}
