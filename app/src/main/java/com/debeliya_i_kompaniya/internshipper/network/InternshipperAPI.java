package com.debeliya_i_kompaniya.internshipper.network;

import com.debeliya_i_kompaniya.internshipper.models.LoginModel;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public interface InternshipperAPI {

    @GET("/login")
    Call<User> loginUser(@Body LoginModel loginModel);

    @POST("/register")
    Call<User> registerUser(@Body User user);

    @GET("/user/offers/")
    Call<ArrayList<OfferWithStatus>> getUserOffers(@Query("userId") int userId);

    @GET("/publisher/offers")
    Call<ArrayList<Offer>> getPublisherOffers();

    @GET("/publisher/userOnOffer/")
    Call<ArrayList<User>> getAllUsersForOffer(@Query("offerId") int offerId);

    @POST("/offers/add")
    void addOffer(@Body Offer offer);

    @GET("/offers")
    Call<ArrayList<Offer>> getAllOffers();

    @DELETE("/deleteOffer")
    void deleteOffer(@Body int offerId);

}
