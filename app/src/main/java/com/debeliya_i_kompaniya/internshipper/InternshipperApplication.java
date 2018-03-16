package com.debeliya_i_kompaniya.internshipper;

import android.app.Application;
import android.content.Context;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class InternshipperApplication extends Application {
    private static InternshipperApplication instance;
    private static Context context;

    public static InternshipperApplication getInstance() {
        if(instance == null) {
            instance = new InternshipperApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getStatic() {
        return context;
    }
}
