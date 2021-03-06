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

    @FormUrlEncoded
    @POST("register")
    Call<ArrayList<UserAccount>> registerUser(
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("password") String password,
            @Field("email") String email,
            @Field("userRole") String userRole);

    @GET("user/applications/")
    Call<ArrayList<OfferWithStatus>> getUserOffers(@Query("userId") int userId);

    @GET("publisher/offers")
    Call<ArrayList<Offer>> getPublisherOffers(@Query("userId") int userId);

    @GET("publisher/userOnOffer/")
    Call<ArrayList<UserAccount>> getAllUsersForOffer(@Query("offerId") int offerId);

    @FormUrlEncoded
    @POST("offers/add")
        Call<Void> addOffer(@Field("publisherId") int publisherId,
                  @Field("internTimeLength") String internTimeLength,
                  @Field("workingHours") int workingHours,
                  @Field("title") String title,
                  @Field("companyName") String companyName,
                  @Field("description") String description,
                  @Field("offerType") String offerType);

    @GET("offers")
    Call<ArrayList<Offer>> getAllOffers();

    @GET("publisher/offers")
    Call<ArrayList<UserAccount>> getAllApplicantsForOffer(@Query("offerId") int offerId);


    @DELETE("/deleteOffer")
    void deleteOffer(@Body int offerId);

}
