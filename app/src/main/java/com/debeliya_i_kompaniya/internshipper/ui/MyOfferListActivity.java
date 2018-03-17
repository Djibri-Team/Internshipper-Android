package com.debeliya_i_kompaniya.internshipper.ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.StartConstants;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BottomNavigationActivity;
import com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview.OnClickMyOffer;
import com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview.MyOfferListRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;

public class MyOfferListActivity extends BottomNavigationActivity {
    @BindView(R.id.rv_my_offers) RecyclerView recyclerView;
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
        adapter = new MyOfferListRecyclerViewAdapter(getMyOffers(), new OnClickMyOffer() {
            @Override
            public void onOfferClick(OfferWithStatus offer, int position) {
                //TODO: IMPLEMENT ME!
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<OfferWithStatus> getMyOffers() {
        ArrayList<OfferWithStatus> myOffers= new ArrayList<>();
        myOffers.add(new OfferWithStatus(new Offer("title", "company", 3, "test"), "PENDING"));
        //TODO: IMPLEMENT ME!

        return myOffers;
    }

}
