package com.debeliya_i_kompaniya.internshipper.view_utils.all_offers_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Stoyan-Ivanov on 17.3.2018 г..
 */

public class OfferViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.offer_job_name)
    TextView tvJobTitle;
    @BindView(R.id.offer_company_name)
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
