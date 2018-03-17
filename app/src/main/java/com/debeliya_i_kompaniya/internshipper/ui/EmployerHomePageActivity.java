package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.debeliya_i_kompaniya.internshipper.DataProvider;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BaseActivity;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview.OfferListRecyclerViewAdapter;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview.OnClickOffer;

import java.util.ArrayList;

import butterknife.BindView;


public class EmployerHomePageActivity extends BaseActivity {

    @BindView(R.id.rv_all_offers) RecyclerView recyclerView;
    private OfferListRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_offer_list);
        configureRecyclerView();
    }

    private void configureRecyclerView() {
        adapter = new OfferListRecyclerViewAdapter(getAllEmployerOffers(), new OnClickOffer() {
            @Override
            public void onOfferClick(Offer offer, int position) {
                Intent intent = new Intent(getBaseContext(), ApplicantsActivity.class);
                intent.putExtra("offer", offer);

                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Offer> getAllEmployerOffers() {
        return DataProvider.getInstance().getAllEmployerOffers();
    }
}
