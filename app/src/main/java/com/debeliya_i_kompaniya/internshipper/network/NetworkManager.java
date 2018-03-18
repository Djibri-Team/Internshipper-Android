package com.debeliya_i_kompaniya.internshipper.network;

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
        final String url = "http://5c45d927.ngrok.io/";

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
