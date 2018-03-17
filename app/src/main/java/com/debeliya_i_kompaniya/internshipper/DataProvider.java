package com.debeliya_i_kompaniya.internshipper;


import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;

import java.util.ArrayList;

public class DataProvider {
    private static DataProvider dataProvider;

    public static DataProvider getInstance() {
        if (dataProvider == null) {
            dataProvider = new DataProvider();
        }
        return dataProvider;
    }


    public ArrayList<Offer> getAllOffers() {
        ArrayList<Offer> allOffers= new ArrayList<>();
        allOffers.add(new Offer("title", "company", 3, "test"));
        return allOffers;
    }

    public ArrayList<OfferWithStatus> getMyOffers() {
        ArrayList<OfferWithStatus> myOffers= new ArrayList<>();
        myOffers.add(new OfferWithStatus(new Offer("title", "company", 3, "test"), "PENDING"));
        return myOffers;
    }


}
