package com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview.OnClickOffer;

import java.util.ArrayList;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class MyOfferListRecyclerViewAdapter extends RecyclerView.Adapter<MyOfferViewHolder> {
    private OnClickOffer listener;
    private ArrayList<OfferWithStatus> offers = new ArrayList<>();

    public MyOfferListRecyclerViewAdapter(ArrayList<OfferWithStatus> offers, OnClickMyOffer listener) {
        this.offers = offers;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @Override
    public MyOfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_my_offer_item, parent, false);



        return new MyOfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyOfferViewHolder holder, int position) {
           holder.bind(offers.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }
}
