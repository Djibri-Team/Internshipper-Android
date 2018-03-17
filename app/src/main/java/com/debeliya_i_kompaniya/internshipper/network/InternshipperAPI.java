package com.debeliya_i_kompaniya.internshipper.network;

import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public interface InternshipperAPI {

    @GET("/login")
    Call<User> loginUser(@Body String email, @Body String password);

    @POST("/register")
    Call<User> registerUser(@Body User user);

    @GET("/user/offers")
    Call<ArrayList<OfferWithStatus>> getUserOffers();

    @GET("/publisher/offers")
    Call<ArrayList<Offer>> getPublisherOffers();

    @GET("/offers")
    Call<ArrayList<Offer>> getAllOffers();

    @DELETE("/deleteOffer")
    void deleteOffer(@Body int offerId);

}
