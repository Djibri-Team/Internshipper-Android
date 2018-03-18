package com.debeliya_i_kompaniya.internshipper.network;

import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.models.UserAccount;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InternshipperAPI {

    @FormUrlEncoded
    @POST("login")
    Call<ArrayList<UserAccount>> logIn(
            @Field("email") String email,
            @Field("password") String password);

    @POST("register")
    Call<UserAccount> registerUser(@Body UserAccount userAccount);

    @GET("user/offers/")
    Call<ArrayList<OfferWithStatus>> getUserOffers(@Query("userId") int userId);

    @GET("publisher/offers")
    Call<ArrayList<Offer>> getPublisherOffers();

    @GET("publisher/userOnOffer/")
    Call<ArrayList<UserAccount>> getAllUsersForOffer(@Query("offerId") int offerId);

    @POST("/offers/add")
    void addOffer(@Body Offer offer);

    @GET("/offers")
    Call<ArrayList<Offer>> getAllOffers();

    @DELETE("/deleteOffer")
    void deleteOffer(@Body int offerId);

}
