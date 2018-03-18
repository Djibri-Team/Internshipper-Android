package com.debeliya_i_kompaniya.internshipper.view_utils.all_applicants_recyclerview.all_offers_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.debeliya_i_kompaniya.internshipper.R;
import com.debeliya_i_kompaniya.internshipper.models.UserAccount;

import java.util.ArrayList;

public class ApplicantListRecyclerViewAdapter extends RecyclerView.Adapter<ApplicantViewHolder> {
    ArrayList<UserAccount> allApplicants;
    OnClickApplicants listener;

    public ApplicantListRecyclerViewAdapter(ArrayList<UserAccount> allApplicants, OnClickApplicants onClickApplicants) {
        this.allApplicants = allApplicants;
        listener = onClickApplicants;
    }

    @Override
    public ApplicantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_applicant, parent, false);

        return new ApplicantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ApplicantViewHolder holder, int position) {
        holder.bind(allApplicants.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return allApplicants.size();
    }
}
