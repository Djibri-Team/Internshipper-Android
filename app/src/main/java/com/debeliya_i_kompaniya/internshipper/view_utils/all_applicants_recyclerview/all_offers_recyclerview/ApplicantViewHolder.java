package com.debeliya_i_kompaniya.internshipper.view_utils.all_applicants_recyclerview.all_offers_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApplicantViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_applicant_name) TextView applicantName;
    @BindView(R.id.tv_applicant_email) TextView applicantEmail;

    public ApplicantViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bind(final User user, final OnClickApplicants listener) {
        applicantName.setText(user.getFirstName() + user.getLastName());
        applicantEmail.setText(user.getEmail());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickApplicant(user, getAdapterPosition());
            }
        });
    }
}
