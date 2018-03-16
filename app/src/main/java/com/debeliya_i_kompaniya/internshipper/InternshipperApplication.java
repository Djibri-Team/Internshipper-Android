package com.debeliya_i_kompaniya.internshipper;

import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Stoyan-Ivanov on 16.3.2018 г..
 */

public class InternshipperApplication extends Application {
    private static InternshipperApplication instance;
    private static Context applicationContext;

    public static InternshipperApplication getInstance() {
        if(instance == null) {
            instance = new InternshipperApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
    }

    public static void showToast(String message) {
        Toast toast=Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL, 0, 100);
        toast.show();
    }

    public static Context getStatic() {
        return applicationContext;
    }
}
