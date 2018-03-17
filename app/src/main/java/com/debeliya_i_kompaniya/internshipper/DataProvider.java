package com.debeliya_i_kompaniya.internshipper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;
import com.debeliya_i_kompaniya.internshipper.enums.UserRole;
import com.debeliya_i_kompaniya.internshipper.models.LoginModel;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.models.User;
import com.debeliya_i_kompaniya.internshipper.network.NetworkManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataProvider {
    private static DataProvider dataProvider;
    private User user;
    private ArrayList<OfferWithStatus> myOffers= new ArrayList<>();
    private ArrayList<Offer> allOffers= new ArrayList<>();

    public static DataProvider getInstance() {
        if (dataProvider == null) {
            dataProvider = new DataProvider();
        }
        return dataProvider;
    }

    public boolean loginUser(LoginModel loginModel) {
        Call<User> loginCall = NetworkManager.getInstance().getAPI().loginUser(loginModel);

        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    user = response.body();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("SII", "onFailure: login of user");
            }
        });

        if(user != null) {
            return true;
        }
        return false;
    }

    public boolean registerUser(final User userForRegistering) {
        Call<User> registerCall = NetworkManager.getInstance().getAPI().registerUser(userForRegistering);

        registerCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    user = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return false;
    }

    public User getUser() {
        User user = new User("Zachary", "Georgiev", "zguri@abv.bg", "ivanegei", "", UserRole.EMPLOYER.toString());

        return user;
    }

    public ArrayList<User> getAllApplicants() {
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers.add(new User(
                "Ivan",
                "Ganchev",
                "vanibani@abv.bg",
                "",
                "azsumgei",
                UserRole.STUDENT.toString()));

        

        return allUsers;
    }

    public ArrayList<Offer> getAllOffers() {
//        ArrayList<Offer> allOffers= new ArrayList<>();
//
//        allOffers.add(new Offer(
//                1,
//                "Software engineer",
//                "Zguri CO",
//                "2 weeks",
//                "8 hours",
//                "Nice meme",
//                JobCategory.SOFTWARE));

        Call<ArrayList<Offer>> allOffersCall = NetworkManager.getInstance().getAPI().getAllOffers();

        allOffersCall.enqueue(new Callback<ArrayList<Offer>>() {
            @Override
            public void onResponse(Call<ArrayList<Offer>> call, Response<ArrayList<Offer>> response) {
                if(response.isSuccessful()) {
                    allOffers = response.body();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Offer>> call, Throwable t) {

            }
        });

        return allOffers;
    }

    public ArrayList<OfferWithStatus> getMyOffers() {
        Call<ArrayList<OfferWithStatus>> myOffersCall = NetworkManager.getInstance().getAPI().getUserOffers(user.getId());

        myOffersCall.enqueue(new Callback<ArrayList<OfferWithStatus>>() {
            @Override
            public void onResponse(Call<ArrayList<OfferWithStatus>> call, Response<ArrayList<OfferWithStatus>> response) {
                if(response.isSuccessful()) {
                    myOffers = response.body();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<OfferWithStatus>> call, Throwable t) {

            }
        });

        return myOffers;
    }
}
