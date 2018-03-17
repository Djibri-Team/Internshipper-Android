package com.debeliya_i_kompaniya.internshipper.view_utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class OfferViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.job_title)
    TextView tvJobTitle;
    @BindView(R.id.company_name)
    TextView tvCompanyName;


    public OfferViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bind(final Offer offer, final OnClickOffer listener) {
        tvJobTitle.setText(offer.getTitle());
        tvCompanyName.setText(offer.getCompany());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onOfferClick(offer, getAdapterPosition());
            }
        });
    }
}
