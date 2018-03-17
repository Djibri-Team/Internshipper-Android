package com.debeliya_i_kompaniya.internshipper.models;

import com.debeliya_i_kompaniya.internshipper.enums.Status;

/**
 * Created by Stoyan-Ivanov on 17.3.2018 г..
 */

public class OfferWithStatus {
    private Offer offer;
    private Status status;

    public OfferWithStatus(Offer offer, String status) {
        this.offer = offer;
        this.status = Status.StringToStatus(status);
    }

    public Offer getOffer() {
        return offer;
    }

    public Status getStatus() {
        return status;
    }
}
