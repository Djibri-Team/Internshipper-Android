package com.debeliya_i_kompaniya.internshipper.view_utils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;

import java.util.ArrayList;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class OfferListRecyclerViewAdapter extends RecyclerView.Adapter<OfferViewHolder> {
    private OnClickOffer listener;
    private ArrayList<Offer> offers = new ArrayList<>();

    public OfferListRecyclerViewAdapter(ArrayList<Offer> offers, OnClickOffer listener) {
        this.offers = offers;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_my_offer_item, parent, false);



        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OfferViewHolder holder, int position) {
           holder.bind(offers.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }
}
