package com.example.sdkintegration_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.clevertap.android.sdk.CleverTapAPI;
import java.util.HashMap;
import java.util.Date;
import android.os.Build;
import android.app.*;
public class MainActivity extends AppCompatActivity  {
//private final String CHANNEL_ID ="abc";
//private final int NOTIFICATION_ID =3131;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();

//Update pre-defined profile properties
        profileUpdate.put("Name", "Joe Root");
        profileUpdate.put("Email", "joe@gmail.com");
//Update custom profile properties
        profileUpdate.put("Plan Type", "Silver");
        profileUpdate.put("Favorite Food", "Pizza");
        profileUpdate.put("Phone", "+14155551234");                 // Phone (with the country code, starting with +)
        profileUpdate.put("Gender", "M");                           // Can be either M or F
        profileUpdate.put("Employed", "Y");                         // Can be either Y or N
        profileUpdate.put("Education", "Graduate");                 // Can be either Graduate, College or School
        profileUpdate.put("Married", "Y");                          // Can be either Y or N
        profileUpdate.put("DOB", new Date());                       // Date of Birth. Set the Date object to the appropriate value first

        clevertapDefaultInstance.pushProfile(profileUpdate);


        // event with properties
        HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
        prodViewedAction.put("Product Name", "Bat");
        prodViewedAction.put("Category", "Sports");
        prodViewedAction.put("Price", 10000);
        prodViewedAction.put("Date", new java.util.Date());

        clevertapDefaultInstance.pushEvent("Product viewed", prodViewedAction);
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.INFO);    //Default Log level

        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);   //Set Log level to DEBUG log warnings or other important messages

        //CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.OFF);     //Switch off logs for Production environment
        CleverTapAPI.createNotificationChannel(getApplicationContext(),"3131","mychannel","lDescription",NotificationManager.IMPORTANCE_MAX,true);



    }


}