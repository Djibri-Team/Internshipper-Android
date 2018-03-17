package com.debeliya_i_kompaniya.internshipper;

import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;
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
        allOffers.add(new Offer(
                "Software engineer",
                "Zguri CO",
                "2 weeks",
                "8 hours",
                "Nice meme",
                JobCategory.SOFTWARE));
        return allOffers;
    }

    public ArrayList<OfferWithStatus> getMyOffers() {
        ArrayList<OfferWithStatus> myOffers= new ArrayList<>();
        myOffers.add(new OfferWithStatus(new Offer(
                "Software engineer",
                "Melon AD",
                "2 weeks",
                "8 hours",
                "Cool meme",
                JobCategory.SOFTWARE),
                "PENDING"));

        return myOffers;
    }
}
