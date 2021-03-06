package com.debeliya_i_kompaniya.internshipper.network;

import android.content.Context;
import android.content.SharedPreferences;

import com.debeliya_i_kompaniya.internshipper.InternshipperApplication;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class NetworkManager {
    private static NetworkManager manager;
    private static Retrofit retrofit;
    private static InternshipperAPI api;

    public static NetworkManager getInstance() {
        if(manager == null) {
            manager = new NetworkManager();
        }
        return manager;
    }

    private NetworkManager() {
        SharedPreferences sharedPreferences = InternshipperApplication.getStatic()
                .getSharedPreferences("Setup", Context.MODE_PRIVATE);

        String urlFromPrefs =  sharedPreferences.getString("url", "");

        final String url = "http://" + urlFromPrefs;

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();

        api = retrofit.create(InternshipperAPI.class);
    }

    public InternshipperAPI getAPI() {
        return api;
    }

}
