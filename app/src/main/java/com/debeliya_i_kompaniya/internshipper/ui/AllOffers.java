package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.StartConstants;
import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BottomNavigationActivity;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview.OfferListRecyclerViewAdapter;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview.OnClickOffer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class AllOffers extends BottomNavigationActivity {
    @BindView(R.id.rv_all_offers) RecyclerView recyclerView;
    @BindView(R.id.fab_add_offer) FloatingActionButton fabAddOffer;
    private OfferListRecyclerViewAdapter adapter;

    @OnClick(R.id.fab_add_offer)
    void startAddOfferActivity() {
        startActivity(new Intent(this, AddOfferActivity.class));
    }

    public static Intent getIntent(Context context, int bottomNavOption) {
        Intent intent = new Intent(context, AllOffers.class);
        intent.putExtra(StartConstants.EXTRA_NAV_OPTION, bottomNavOption);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_offer_list);
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
        ArrayList<Offer> allOffers= new ArrayList<>();
        allOffers.add(new Offer(
                "Software engineer",
                "Zguri CO",
                "2 weeks",
                "8 hours",
                "Nice meme",
                JobCategory.SOFTWARE));
//        allOffers.add(new Offer("title", "company", 3, "test"));
        //TODO: IMPLEMENT ME!

        return allOffers;
    }
}
