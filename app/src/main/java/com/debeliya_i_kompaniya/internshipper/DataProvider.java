package com.debeliya_i_kompaniya.internshipper;

import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;
import com.debeliya_i_kompaniya.internshipper.enums.UserRole;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.models.User;

import java.util.ArrayList;

public class DataProvider {
    private static DataProvider dataProvider;

    public static DataProvider getInstance() {
        if (dataProvider == null) {
            dataProvider = new DataProvider();
        }
        return dataProvider;
    }

    public User getUser() {
        User user = new User("Zachary", "Georgiev", "zguri@abv.bg", "ivanegei", UserRole.STUDENT);

        return user;
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
                "ACCEPTED"));

        return myOffers;
    }
}
