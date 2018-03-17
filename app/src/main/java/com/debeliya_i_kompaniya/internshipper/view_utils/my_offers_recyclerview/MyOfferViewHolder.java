package com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.debeliya_i_kompaniya.internshipper.InternshipperApplication;
import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.enums.Status;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class MyOfferViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.job_title) TextView tvJobTitle;
    @BindView(R.id.company_name) TextView tvCompanyName;
    @BindView(R.id.status_indicator) ImageView ivStatusIndicator;

    public MyOfferViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bind(final OfferWithStatus offerWithStatus, final OnClickMyOffer listener) {
        tvJobTitle.setText(offerWithStatus.getOffer().getTitle());
        tvCompanyName.setText(offerWithStatus.getOffer().getCompany());
        setStatusState(offerWithStatus.getStatus());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onOfferClick(offerWithStatus, getAdapterPosition());
            }
        });
    }

    private void setStatusState(Status status) {
        switch(status) {
            case PENDING: ivStatusIndicator.setImageResource(R.drawable.pending_icon); break;
            case ACCEPTED: ivStatusIndicator.setImageResource(R.drawable.accepted_icon); break;
            case REJECTED: ivStatusIndicator.setImageResource(R.drawable.rejected_icon); break;
            default:
                InternshipperApplication.showToast("No status available");
        }
    }
}
