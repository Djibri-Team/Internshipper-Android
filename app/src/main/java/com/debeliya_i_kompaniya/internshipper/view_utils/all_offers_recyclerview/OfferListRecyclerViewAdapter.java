package com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview.MyOfferViewHolder;

import java.util.ArrayList;

public class OfferListRecyclerViewAdapter extends RecyclerView.Adapter<OfferViewHolder> {
    ArrayList<Offer> allOffers;
    OnClickOffer listener;

    public OfferListRecyclerViewAdapter(ArrayList<Offer> allOffers, OnClickOffer onClickOffer) {
        this.allOffers = allOffers;
        listener = onClickOffer;
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_offer, parent, false);

        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OfferViewHolder holder, int position) {
        holder.bind(allOffers.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return allOffers.size();
    }
}
