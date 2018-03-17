package com.debeliya_i_kompaniya.internshipper.view_utils.my_offers_recyclerview;

import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;

/**
 * Created by Stoyan-Ivanov on 17.3.2018 г..
 */

public interface OnClickMyOffer {
    void onOfferClick(OfferWithStatus offer, int position);
}
