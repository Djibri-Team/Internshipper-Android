package com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.debeliya_i_kompaniya.internshipper.models.Offer;

import java.util.ArrayList;

/**
 * Created by Stoyan-Ivanov on 17.3.2018 г..
 */

public class OfferListRecyclerViewAdapter extends RecyclerView.Adapter {
    ArrayList<Offer> allOffers;
    OnClickOffer listener;

    public OfferListRecyclerViewAdapter(ArrayList<Offer> allOffers, OnClickOffer onClickOffer) {
        this.allOffers = allOffers;
        listener = onClickOffer;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
