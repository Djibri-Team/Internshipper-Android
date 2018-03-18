package com.debeliya_i_kompaniya.internshipper;

import android.util.Log;

import com.debeliya_i_kompaniya.internshipper.enums.JobCategory;
import com.debeliya_i_kompaniya.internshipper.enums.UserRole;
import com.debeliya_i_kompaniya.internshipper.models.LoginModel;
import com.debeliya_i_kompaniya.internshipper.models.Offer;
import com.debeliya_i_kompaniya.internshipper.models.OfferWithStatus;
import com.debeliya_i_kompaniya.internshipper.models.UserAccount;
import com.debeliya_i_kompaniya.internshipper.network.NetworkManager;
import com.debeliya_i_kompaniya.internshipper.ui.AllOffersActivity;
import com.debeliya_i_kompaniya.internshipper.ui.ApplicantsActivity;
import com.debeliya_i_kompaniya.internshipper.ui.EmployerHomePageActivity;
import com.debeliya_i_kompaniya.internshipper.ui.LoginActivity;
import com.debeliya_i_kompaniya.internshipper.ui.SignUpActivity;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataProvider {
    private static DataProvider dataProvider;
    private static UserAccount userAccount;
    private ArrayList<OfferWithStatus> myOffers= new ArrayList<>();
    private ArrayList<Offer> allOffers= new ArrayList<>();

    public static DataProvider getInstance() {
        if (dataProvider == null) {
            dataProvider = new DataProvider();
        }
        return dataProvider;
    }

    public boolean loginUser(LoginModel loginModel, final LoginActivity loginActivity) {
        Call<ArrayList<UserAccount>> loginCall = NetworkManager.getInstance().getAPI().logIn(loginModel.getEmail(), loginModel.getPassword());

        loginCall.enqueue(new Callback<ArrayList<UserAccount>>() {
            @Override
            public void onResponse(Call<ArrayList<UserAccount>> call, Response<ArrayList<UserAccount>> response) {

                if(response.isSuccessful()) {
                    userAccount = response.body().get(0);
                    loginActivity.getUserFromDatabase();
                    Log.d("SII", "onResponse: " + userAccount.toString());
                }
            }
            @Override
            public void onFailure(Call<ArrayList<UserAccount>> call, Throwable t) {

                Log.d("SII", "onFailure: " + t.getMessage());
            }
        });

        if(userAccount != null) {
            return true;
        }
        return false;
    }

    public boolean registerUser(final String firstName, final String lastName, final String email, final String password, final String userRole, final SignUpActivity signUpActivity) {
//        Log.d("SII", "registerUser: " + userAccountForRegistering.toString());
        Call<ArrayList<UserAccount>> registerCall = NetworkManager.getInstance().getAPI().registerUser(firstName, lastName, password, email, userRole);

        registerCall.enqueue(new Callback<ArrayList<UserAccount>>() {
            @Override
            public void onResponse(Call<ArrayList<UserAccount>> call, Response<ArrayList<UserAccount>> response) {
                if(response.isSuccessful()) {
                    userAccount = response.body().get(0);
                    signUpActivity.startNewActivity();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserAccount>> call, Throwable t) {
                Log.d("SII", "onFailure: " + t.getMessage());
            }
        });
        return false;
    }

    public UserAccount getUserAccount() {

        //UserAccount userAccount = new UserAccount("Zachary", "Georgiev", "zguri@abv.bg", "ivanegei", "", UserRole.EMPLOYER.toString());
        Log.d("SII", "getUserAccount: " + userAccount.toString());
        return userAccount;
    }

    public void getAllApplicants(final ApplicantsActivity applicantsActivity, int id) {
        Call<ArrayList<UserAccount>> getApplicantsCallback = NetworkManager
                .getInstance().getAPI().getAllApplicantsForOffer(id);

        getApplicantsCallback.enqueue(new Callback<ArrayList<UserAccount>>() {
            @Override
            public void onResponse(Call<ArrayList<UserAccount>> call, Response<ArrayList<UserAccount>> response) {
                if(response.isSuccessful()) {
                    applicantsActivity.setDataToAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UserAccount>> call, Throwable t) {

            }
        });

    }

    public ArrayList<Offer> getAllOffers(final AllOffersActivity allOffersActivity) {
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
                    Log.d("SII", "onResponse: " + allOffers.toString());
                    allOffersActivity.setNewDataToAdapter(allOffers);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Offer>> call, Throwable t) {

            }
        });

        return allOffers;
    }

    public ArrayList<OfferWithStatus> getMyOffers() {
        Call<ArrayList<OfferWithStatus>> myOffersCall = NetworkManager.getInstance().getAPI().getUserOffers(userAccount.getId());

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

    public void getAllEmployerOffers(final EmployerHomePageActivity employerHomePageActivity) {
        int userId = userAccount.getId();

        Call<ArrayList<Offer>> publisherOffersCallback= NetworkManager.getInstance().getAPI().getPublisherOffers(userId);

        publisherOffersCallback.enqueue(new Callback<ArrayList<Offer>>() {
            @Override
            public void onResponse(Call<ArrayList<Offer>> call, Response<ArrayList<Offer>> response) {
                if(response.isSuccessful()) {
                    employerHomePageActivity.setNewDataToAdapter(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Offer>> call, Throwable t) {

            }
        });
    }

    public void addOffer(Offer offer) throws IOException {
        Log.d("SII", "addOffer: " + offer.toString());
        Call<Void> callback = NetworkManager.getInstance().getAPI().addOffer(offer.getPublisherId(), offer.getInternTimeLength(),
                offer.getWorkingHours(), offer.getTitle(), offer.getCompanyName(),
                offer.getDescription(), offer.getType().toString());

        callback.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("SII", "onFailure: add " + t.getMessage());
            }
        });

    }

}
