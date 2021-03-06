package com.debeliya_i_kompaniya.internshipper.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.debeliya_i_kompaniya.internshipper.DataProvider;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.constants.StartConstants;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.ui.base_activities.BottomNavigationActivity;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview.OfferListRecyclerViewAdapter;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview.OnClickOffer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class AllOffersActivity extends BottomNavigationActivity {
    @BindView(R.id.rv_all_offers) RecyclerView recyclerView;
    private OfferListRecyclerViewAdapter adapter;

    public static Intent getIntent(Context context, int bottomNavOption) {
        Intent intent = new Intent(context, AllOffersActivity.class);
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
                Intent intent = new Intent(getBaseContext(), InternshipDetailsActivity.class);
                intent.putExtra("offer", offer);

                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Offer> getAllOffers() {
        return DataProvider.getInstance().getAllOffers(this);
    }

    public void setNewDataToAdapter(ArrayList<Offer> allOffers) {
        adapter.setData(allOffers);
    }
}
